// --- Creo las variables globales ---
let consultaData = {
  ciudad:    null,
  aerolinea: null,
  vuelo:     null,
  asiento:   null,

  usuario: {
    nombre:     null,
    apellido:   null,
    dni:        null,
    correo:     null,
    contraseña: null
  },

  tarjeta: {
    numero:   null,
    tipo:     null,
    cantidad: null
  },

  idConsulta: null
};

const ciudadSelect     = document.getElementById('ciudad');
const aerolineaSelect  = document.getElementById('aerolinea');
const vueloSelect      = document.getElementById('vuelo');
const asientoSelect    = document.getElementById('asiento');

const stepMenuOne      = document.querySelector('.formbold-step-menu1');
const stepMenuTwo      = document.querySelector('.formbold-step-menu2');
const stepMenuThree    = document.querySelector('.formbold-step-menu3');
const stepMenuFour     = document.querySelector('.formbold-step-menu4');

const stepOne          = document.querySelector('.formbold-form-step-1');
const stepTwo          = document.querySelector('.formbold-form-step-2');
const stepThree        = document.querySelector('.formbold-form-step-3');
const stepFour         = document.querySelector('.formbold-form-step-4');

const formSubmitBtn    = document.querySelector('.formbold-btn');
const formBackBtn      = document.querySelector('.formbold-back-btn');

// --- Inicializo ---
document.addEventListener('DOMContentLoaded', () => {
  loadCiudades();
  loadAerolineas();
});

// --- Declaro las funciones de carga ---
async function loadCiudades() {
  try {
    const res = await fetch('http://localhost:8080/ciudades/ciudades');
    const ciudades = await res.json();
    ciudadSelect.innerHTML = '<option value="">Seleccione una ciudad</option>';
    ciudades.forEach(c => {
      const opt = document.createElement('option');
      opt.value = c.id;
      opt.textContent = c.nombreCiudad;
      ciudadSelect.appendChild(opt);
    });
  } catch (err) {
    console.error('Error cargando ciudades:', err);
  }
}

async function loadAerolineas() {
  try {
    const res = await fetch('http://localhost:8080/aerolineas/aerolineas');
    const aerolineas = await res.json();
    aerolineaSelect.innerHTML = '<option value="">Seleccione una aerolínea</option>';
    aerolineas.forEach(a => {
      const opt = document.createElement('option');
      opt.value = a.id;
      opt.textContent = a.nombreAerolinea;
      aerolineaSelect.appendChild(opt);
    });
  } catch (err) {
    console.error('Error cargando aerolíneas:', err);
  }
}

async function loadVuelos() {
  const ciudadId    = ciudadSelect.value;
  const aerolineaId = aerolineaSelect.value;
  
  if (!ciudadId || !aerolineaId) {
    vueloSelect.innerHTML = '<option value="">Seleccione un vuelo</option>';
    return;
  }
  
  try {
    console.log(`🔍 Buscando vuelos para ciudad ${ciudadId} y aerolínea ${aerolineaId}`);
    
    //Tuve q hacer una prueba de debugging para ver los errores q me daba
    const debugRes = await fetch(`http://localhost:8080/vuelos/debug/test-ciudad-aerolinea?ciudad=${ciudadId}&aerolinea=${aerolineaId}`);
    if (debugRes.ok) {
      const debugInfo = await debugRes.json();
      console.log('📊 Info de debugging:', debugInfo);
    }
    
    //Si funionó lo anterior, hago la búsqueda real
    const res = await fetch(`http://localhost:8080/vuelos/filtrar?ciudad=${ciudadId}&aerolinea=${aerolineaId}`);
    
    if (!res.ok) {
      throw new Error(`HTTP ${res.status}: ${res.statusText}`);
    }
    
    const vuelos = await res.json();
    console.log('✈️ Vuelos recibidos:', vuelos);

    vueloSelect.innerHTML = '<option value="">Seleccione un vuelo</option>';
    
    if (vuelos.length === 0) {
      vueloSelect.innerHTML = '<option value="">No hay vuelos disponibles</option>';
      console.warn('⚠️ No se encontraron vuelos para los criterios seleccionados');
      
      // Si no hay vuelos, muestro información adicional de debugging
      console.log('🔧 Ejecutando debugging adicional...');
      try {
        const detalleRes = await fetch('http://localhost:8080/vuelos/debug/vuelos-detalle');
        if (detalleRes.ok) {
          const detalles = await detalleRes.json();
          console.log('📋 Detalles de todos los vuelos:', detalles);
        }
      } catch (debugErr) {
        console.error('Error en debugging:', debugErr);
      }
      
    } else {
      vuelos.forEach(v => {
        const opt = document.createElement('option');
        opt.value = v.id;
        
        // Mejoré el texto con la información del vuelo
        let textoVuelo = `Vuelo ${v.id}`;
        if (v.avion?.modelo) {
          textoVuelo += ` - ${v.avion.modelo}`;
        }
        
        // Muestro información de aeropuertos si está disponible
        if (v.aeropuertos && v.aeropuertos.length > 0) {
          const nombresAeropuertos = v.aeropuertos
            .map(a => a.nombreAeropuerto)
            .join(' → ');
          textoVuelo += ` (${nombresAeropuertos})`;
        }
        
        opt.textContent = textoVuelo;
        vueloSelect.appendChild(opt);
      });
      console.log(`✅ Se cargaron ${vuelos.length} vuelos exitosamente`);
    }
  } catch (err) {
    console.error('💥 Error cargando vuelos:', err);
    vueloSelect.innerHTML = '<option value="">Error al cargar vuelos</option>';
    
    // Muestro información adicional del error en consola
    console.error('Detalles del error:', {
      message: err.message,
      stack: err.stack,
      ciudadId: ciudadId,
      aerolineaId: aerolineaId
    });
  }
}

// Hago una función adicional para el debugging manual
async function debugVuelos() {
  try {
    console.log('🔧 Iniciando debugging manual...');
    
    const res = await fetch('http://localhost:8080/vuelos/debug/vuelos-detalle');
    if (res.ok) {
      const detalles = await res.json();
      console.log('📊 Todos los vuelos con detalles:', detalles);
      
      // Analizo los datos
      console.log(`📈 Total de vuelos: ${detalles.length}`);
      console.log(`📈 Vuelos con aerolínea: ${detalles.filter(v => v.aerolineaId).length}`);
      console.log(`📈 Vuelos con aeropuertos: ${detalles.filter(v => v.cantidadAeropuertos > 0).length}`);
      
      // Muestro las aerolíneas únicas
      const aerolineas = [...new Set(detalles.map(v => v.aerolineaNombre).filter(Boolean))];
      console.log(`🏢 Aerolíneas disponibles: ${aerolineas.join(', ')}`);
      
      // Muestro las ciudades únicas
      const ciudades = [...new Set(detalles.flatMap(v => 
        v.aeropuertos.map(a => a.ciudadNombre).filter(Boolean)
      ))];
      console.log(`🏙️ Ciudades disponibles: ${ciudades.join(', ')}`);
      
    } else {
      console.error('Error obteniendo detalles de debugging');
    }
  } catch (err) {
    console.error('Error en debugging manual:', err);
  }
}

async function loadAsientos() {
  const vueloNum = vueloSelect.value;
  if (!vueloNum) return;
  try {
    const res = await fetch(`http://localhost:8080/vuelos/vuelo/${vueloNum}/asientos`);
    const asientos = await res.json();
    asientoSelect.innerHTML = '<option value="">Seleccione un asiento</option>';
    if (asientos.length === 0) {
      asientoSelect.innerHTML = '<option value="">No hay asientos disponibles</option>';
    } else {
      asientos.forEach(num => {
        const opt = document.createElement('option');
        opt.value = num;
        opt.textContent = num;
        asientoSelect.appendChild(opt);
      });
    }
  } catch (err) {
    console.error('Error cargando asientos:', err);
    asientoSelect.innerHTML = '<option value="">Error al cargar asientos</option>';
  }
}

// Hice una función para mostrar los datos de la reserva en la tabla
async function mostrarDatosReserva() {
  const tablaBody = document.getElementById('tablaArticulos');
  
  //Obtengo los nombres de la ciudad y la aerolínea en base a los IDs seleccionados
  const ciudadNombre = ciudadSelect.options[ciudadSelect.selectedIndex]?.text || 'N/A';
  const aerolineaNombre = aerolineaSelect.options[aerolineaSelect.selectedIndex]?.text || 'N/A';
  const vueloTexto = vueloSelect.options[vueloSelect.selectedIndex]?.text || 'N/A';

  // Creo la fila con los datos
  const fila = document.createElement('tr');
  fila.innerHTML = `
    <td>${consultaData.usuario.nombre}</td>
    <td>${consultaData.usuario.apellido}</td>
    <td>${vueloTexto}</td>
    <td>${consultaData.asiento}</td>
    <td>${ciudadNombre}</td>
    <td>${aerolineaNombre}</td>
    
  `;
  // <td>${fechaVuelo}</td>
  
  // Limpio tabla y agrego la nueva fila
  tablaBody.innerHTML = '';
  tablaBody.appendChild(fila);
}

ciudadSelect.addEventListener('change', loadVuelos);
aerolineaSelect.addEventListener('change', loadVuelos);
vueloSelect.addEventListener('change', loadAsientos);

// --- Esto es para navegar hacia atrás entre secciones, pero la verdad fue una pesima idea ---
formBackBtn.addEventListener('click', e => {
  e.preventDefault();
  
  if (stepMenuFour.classList.contains('active')) {
    stepMenuFour.classList.remove('active');
    stepMenuThree.classList.add('active');
    stepFour.classList.remove('active');
    stepThree.classList.add('active');
    formSubmitBtn.textContent = 'Confirmar Reserva';
    formSubmitBtn.style.display = 'inline-block';
  } else if (stepMenuThree.classList.contains('active')) {
    stepMenuThree.classList.remove('active');
    stepMenuTwo.classList.add('active');
    stepThree.classList.remove('active');
    stepTwo.classList.add('active');
    formSubmitBtn.textContent = 'Siguiente';
  } else if (stepMenuTwo.classList.contains('active')) {
    stepMenuTwo.classList.remove('active');
    stepMenuOne.classList.add('active');
    stepTwo.classList.remove('active');
    stepOne.classList.add('active');
    formBackBtn.classList.remove('active');
    formSubmitBtn.textContent = 'Siguiente';
  }
});

// --- Al enviar:  ---
formSubmitBtn.addEventListener('click', async e => {
  e.preventDefault();

  // PASO 1: Se crea la consulta
  if (stepMenuOne.classList.contains('active')) {
    consultaData.vuelo   = vueloSelect.value;
    consultaData.asiento = asientoSelect.value;
    if (!consultaData.vuelo || !consultaData.asiento) {
      return alert('Completa todos los campos del Paso 1.');
    }

    try {
      const res = await fetch('http://localhost:8080/consultas/guardarConsulta', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          vuelo: { id: Number(consultaData.vuelo) }
        })
      });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);

      //Recibo el JSON con la consulta guardada
      const saved = await res.json();
      consultaData.idConsulta = saved.id;
      console.log('✅ Consulta guardada, ID=', consultaData.idConsulta);

      //Avanzo al paso 2
      stepMenuOne.classList.remove('active');
      stepMenuTwo.classList.add('active');
      stepOne.classList.remove('active');
      stepTwo.classList.add('active');
      formBackBtn.classList.add('active');
      formSubmitBtn.textContent = 'Siguiente';

    } catch (err) {
      console.error('Error guardando consulta:', err);
      alert('No se pudo guardar la consulta.');
    }

  // PASO 2: Procesar los datos del usuario
  } else if (stepMenuTwo.classList.contains('active')) {
    consultaData.usuario.nombre     = document.getElementById('firstname').value.trim();
    consultaData.usuario.apellido   = document.getElementById('lastname').value.trim();
    consultaData.usuario.dni        = document.getElementById('dni').value.trim();
    consultaData.usuario.correo     = document.getElementById('email').value.trim();
    consultaData.usuario.contraseña = document.getElementById('password').value;
    if (!consultaData.usuario.nombre ||
        !consultaData.usuario.apellido ||
        !consultaData.usuario.dni ||
        !consultaData.usuario.correo ||
        !consultaData.usuario.contraseña) {
      return alert('Completa todos los campos del Paso 2.');
    }

    stepMenuTwo.classList.remove('active');
    stepMenuThree.classList.add('active');
    stepTwo.classList.remove('active');
    stepThree.classList.add('active');
    formBackBtn.classList.add('active');
    formSubmitBtn.textContent = 'Confirmar Reserva';

  // PASO 3: Procesar la tarjeta, la reserva y el suario
  } else if (stepMenuThree.classList.contains('active')) {
    const numTarjeta = document.getElementById('cardNumber').value.trim();
    const tipoTarjeta = document.getElementById('cardType').value.trim().toUpperCase();
    if (!numTarjeta || !tipoTarjeta) {
      return alert('Completa todos los campos del Paso 3.');
    }

    try {
      // Guardo la tarjeta
      const resT = await fetch('http://localhost:8080/tarjetas/guardarTarjeta', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          numeroTarjeta: Number(numTarjeta),
          tipoTarjeta,
          cantidadPago: 50000
        })
      });
      if (!resT.ok) throw new Error(`Tarjeta ${resT.status}`);
      const savedCard = await resT.json();

      // Guardo la reserva
      const resR = await fetch('http://localhost:8080/reservas/guardarReserva', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ 
          vuelo: { id: Number(consultaData.vuelo) } 
        })
      });
      if (!resR.ok) throw new Error(`Reserva ${resR.status}`);
      const savedReserva = await resR.json();

      // Guardo el usuario
      const payloadU = {
        dni: consultaData.usuario.dni,
        nombre: consultaData.usuario.nombre,
        apellido: consultaData.usuario.apellido,
        contraseñaUsuario: consultaData.usuario.contraseña,
        correoElectronicoUsuario: consultaData.usuario.correo,
        consultas:  [{ id: consultaData.idConsulta }],
        reservas:   [{ id: savedReserva.id }],
        tarjetas:   [{ id: savedCard.id }]
      };
      const resU = await fetch('http://localhost:8080/usuarios/guardarUsuario', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payloadU)
      });
      if (!resU.ok) throw new Error(`Usuario ${resU.status}`);
      await resU.json();

      alert('¡Reserva confirmada!');

      //Voy al paso 4
      stepMenuThree.classList.remove('active');
      stepMenuFour.classList.add('active');
      stepThree.classList.remove('active');
      stepFour.classList.add('active');
      //Tuve que ocultar el boton de enviar por el html
      formSubmitBtn.style.display = 'none';
      
      //Muestro los datos de la reserva en la tabla
      mostrarDatosReserva();

    } catch (err) {
      console.error('Error finalizando flujo:', err);
      alert('Error guardando datos finales.');
    }
  }
});