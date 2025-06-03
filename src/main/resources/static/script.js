// --- Variables globales ---
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

// --- Inicialización ---
document.addEventListener('DOMContentLoaded', () => {
  loadCiudades();
  loadAerolineas();
});

// --- Funciones de carga ---
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
    const res = await fetch(`http://localhost:8080/vuelos/filtrar?ciudad=${ciudadId}&aerolinea=${aerolineaId}`);
    const vuelos = await res.json();

    vueloSelect.innerHTML = '<option value="">Seleccione un vuelo</option>';
    if (vuelos.length === 0) {
      vueloSelect.innerHTML = '<option value="">No hay vuelos disponibles</option>';
    } else {
      vuelos.forEach(v => {
        const opt = document.createElement('option');
        opt.value = v.id;  // <-- usamos v.id, que es el @Id de Vuelo
        opt.textContent = `Vuelo ${v.id} – ${v.avion?.modelo || 'Sin modelo'}`;
        vueloSelect.appendChild(opt);
      });
    }
  } catch (err) {
    console.error('Error cargando vuelos:', err);
    vueloSelect.innerHTML = '<option value="">Error al cargar vuelos</option>';
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

// Función para mostrar los datos de la reserva en la tabla
async function mostrarDatosReserva() {
  const tablaBody = document.getElementById('tablaArticulos');
  
  // Obtener nombres de ciudad y aerolínea basados en los IDs seleccionados
  const ciudadNombre = ciudadSelect.options[ciudadSelect.selectedIndex]?.text || 'N/A';
  const aerolineaNombre = aerolineaSelect.options[aerolineaSelect.selectedIndex]?.text || 'N/A';
  const vueloTexto = vueloSelect.options[vueloSelect.selectedIndex]?.text || 'N/A';

  // Crear fila con los datos
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
  
  // Limpiar tabla y agregar la nueva fila
  tablaBody.innerHTML = '';
  tablaBody.appendChild(fila);
}

ciudadSelect.addEventListener('change', loadVuelos);
aerolineaSelect.addEventListener('change', loadVuelos);
vueloSelect.addEventListener('change', loadAsientos);

// --- Navegación Back ---
formBackBtn.addEventListener('click', e => {
  e.preventDefault();
  
  if (stepMenuFour.classList.contains('active')) {
    // Volver de paso 4 a paso 3
    stepMenuFour.classList.remove('active');
    stepMenuThree.classList.add('active');
    stepFour.classList.remove('active');
    stepThree.classList.add('active');
    formSubmitBtn.textContent = 'Confirmar Reserva';
    formSubmitBtn.style.display = 'inline-block';
  } else if (stepMenuThree.classList.contains('active')) {
    // Volver de paso 3 a paso 2
    stepMenuThree.classList.remove('active');
    stepMenuTwo.classList.add('active');
    stepThree.classList.remove('active');
    stepTwo.classList.add('active');
    formSubmitBtn.textContent = 'Siguiente';
  } else if (stepMenuTwo.classList.contains('active')) {
    // Volver de paso 2 a paso 1
    stepMenuTwo.classList.remove('active');
    stepMenuOne.classList.add('active');
    stepTwo.classList.remove('active');
    stepOne.classList.add('active');
    formBackBtn.classList.remove('active');
    formSubmitBtn.textContent = 'Siguiente';
  }
});

// --- Next / Submit ---
formSubmitBtn.addEventListener('click', async e => {
  e.preventDefault();

  // PASO 1: crear Consulta
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

      // Ahora recibimos JSON con la Consulta guardada
      const saved = await res.json();
      consultaData.idConsulta = saved.id;
      console.log('✅ Consulta guardada, ID=', consultaData.idConsulta);

      // Avanzar a Paso 2
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

  // PASO 2: datos usuario
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

  // PASO 3: tarjeta, reserva y usuario - LUEGO IR AL PASO 4
  } else if (stepMenuThree.classList.contains('active')) {
    const numTarjeta = document.getElementById('cardNumber').value.trim();
    const tipoTarjeta = document.getElementById('cardType').value.trim().toUpperCase();
    if (!numTarjeta || !tipoTarjeta) {
      return alert('Completa todos los campos del Paso 3.');
    }

    try {
      // Guardar tarjeta
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

      // Guardar reserva
      const resR = await fetch('http://localhost:8080/reservas/guardarReserva', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ consulta: { id: consultaData.idConsulta } })
      });
      if (!resR.ok) throw new Error(`Reserva ${resR.status}`);
      const savedReserva = await resR.json();

      // Guardar usuario
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

      // NAVEGAR AL PASO 4 Y MOSTRAR DATOS
      stepMenuThree.classList.remove('active');
      stepMenuFour.classList.add('active');
      stepThree.classList.remove('active');
      stepFour.classList.add('active');
      
      // Ocultar el botón de submit en el paso 4
      formSubmitBtn.style.display = 'none';
      
      // Mostrar los datos en la tabla
      mostrarDatosReserva();

    } catch (err) {
      console.error('Error finalizando flujo:', err);
      alert('Error guardando datos finales.');
    }
  }
});