# GUÍA PARA COMPLETAR LOS MÓDULOS RESTANTES

## Introducción

El proyecto GoRide tiene el **módulo de Usuarios completamente implementado** como referencia. Esta guía explica cómo replicar el mismo patrón para los módulos restantes: Roles, Conductores, Viajes y Servicios.

---

## PATRÓN YA IMPLEMENTADO (Módulo Usuarios)

### Estructura del Módulo de Usuarios

```
Modelo (Ya creado):
✅ Usuario.java (entidad)
✅ UsuarioDao.java (acceso a datos)
✅ RepositorioUsuario.java (lógica de negocio)

Vista (Ya creado):
✅ activity_lista_usuarios.xml
✅ activity_formulario_usuario.xml
✅ item_usuario.xml

Controlador (Ya creado):
✅ ActividadListaUsuarios.java
✅ ActividadFormularioUsuario.java
✅ AdaptadorUsuario.java
```

---

## MÓDULO 1: ROLES

### Archivos a Crear

#### Vista
1. **activity_lista_roles.xml** (Copiar de activity_lista_usuarios.xml)
2. **activity_formulario_rol.xml** (Similar a formulario_usuario.xml pero con campos de Rol)
3. **item_rol.xml** (Copiar de item_usuario.xml)

#### Controlador
1. **ActividadListaRoles.java** (Copiar de ActividadListaUsuarios.java)
2. **ActividadFormularioRol.java** (Copiar de ActividadFormularioUsuario.java)
3. **AdaptadorRol.java** (Copiar de AdaptadorUsuario.java)

### Campos del Formulario de Rol
```xml
- Nombre del Rol (TextInputEditText)
- Descripción (TextInputEditText - multiline)
- Estado (Spinner: Activo/Inactivo)
```

### Cambios Necesarios

1. **En activity_lista_roles.xml:**
   - Cambiar `textoTitulo` a "Gestión de Roles"
   - Cambiar id de RecyclerView: `listaRoles`

2. **En ActividadListaRoles.java:**
   - Cambiar `RepositorioUsuario` por `RepositorioRol`
   - Cambiar `List<Usuario>` por `List<Rol>`
   - Cambiar `AdaptadorUsuario` por `AdaptadorRol`

3. **En activity_formulario_rol.xml:**
   - 2 campos: nombreRol, descripcion
   - 1 spinner: estado

4. **En ActividadFormularioRol.java:**
   - Usar `RepositorioRol`
   - Validar campos de Rol
   - Crear/actualizar `Rol`

5. **Registrar en AndroidManifest.xml:**
```xml
<activity
    android:name=".controlador.ActividadListaRoles"
    android:exported="false" />
<activity
    android:name=".controlador.ActividadFormularioRol"
    android:exported="false" />
```

6. **En ActividadMenuPrincipal.java:**
```java
private void abrirGestionRoles() {
    Intent intent = new Intent(this, ActividadListaRoles.class);
    startActivity(intent);
}
```

---

## MÓDULO 2: CONDUCTORES

### Archivos a Crear

#### Vista
1. **activity_lista_conductores.xml**
2. **activity_formulario_conductor.xml**
3. **item_conductor.xml**

#### Controlador
1. **ActividadListaConductores.java**
2. **ActividadFormularioConductor.java**
3. **AdaptadorConductor.java**

### Campos del Formulario de Conductor
```xml
- Spinner de Usuario (para asignar conductor a un usuario)
- Licencia de Conducir (TextInputEditText)
- Placa del Vehículo (TextInputEditText)
- Modelo del Vehículo (TextInputEditText)
- Color del Vehículo (TextInputEditText)
- Año del Vehículo (TextInputEditText - number)
- Estado (Spinner: Activo/Inactivo)
```

### Particularidades

1. **Cargar usuarios para el Spinner:**
```java
private void configurarSpinnerUsuarios() {
    RepositorioUsuario repoUsuario = new RepositorioUsuario(this);
    List<Usuario> usuarios = repoUsuario.obtenerPorRol(3); // Rol Conductor
    // Crear adaptador y asignar al spinner
}
```

2. **Validaciones especiales:**
   - Validar formato de placa (usar `ValidadorDatos.esPlacaValida()`)
   - Validar año del vehículo (usar `ValidadorDatos.esAnioValido()`)

---

## MÓDULO 3: VIAJES

### Archivos a Crear

#### Vista
1. **activity_lista_viajes.xml**
2. **activity_formulario_viaje.xml**
3. **item_viaje.xml**

#### Controlador
1. **ActividadListaViajes.java**
2. **ActividadFormularioViaje.java**
3. **AdaptadorViaje.java**

### Campos del Formulario de Viaje
```xml
- Spinner de Usuario (cliente)
- Spinner de Conductor
- Spinner de Servicio
- Origen (TextInputEditText)
- Destino (TextInputEditText)
- Fecha del Viaje (TextInputEditText con DatePicker)
- Hora del Viaje (TextInputEditText con TimePicker)
- Distancia en Km (TextInputEditText - decimal)
- Estado (Spinner: Pendiente/En Curso/Completado/Cancelado)
- Tarifa (TextView - calculada automáticamente)
```

### Particularidades

1. **Cálculo automático de tarifa:**
```java
private void calcularTarifa() {
    Servicio servicio = servicios.get(spinnerServicio.getSelectedItemPosition());
    double distancia = Double.parseDouble(campoDistancia.getText().toString());
    double tarifa = CalculadoraTarifa.calcularTarifaRedondeada(servicio, distancia);
    textoTarifa.setText(CalculadoraTarifa.formatearTarifa(tarifa));
}
```

2. **Mostrar tarifa en el item:**
```xml
<TextView
    android:id="@+id/textoTarifa"
    android:text="Tarifa: $12,500.00" />
```

---

## MÓDULO 4: SERVICIOS

### Archivos a Crear

#### Vista
1. **activity_lista_servicios.xml**
2. **activity_formulario_servicio.xml**
3. **item_servicio.xml**

#### Controlador
1. **ActividadListaServicios.java**
2. **ActividadFormularioServicio.java**
3. **AdaptadorServicio.java**

### Campos del Formulario de Servicio
```xml
- Nombre del Servicio (TextInputEditText)
- Descripción (TextInputEditText - multiline)
- Precio Base (TextInputEditText - decimal)
- Precio por Kilómetro (TextInputEditText - decimal)
- Estado (Spinner: Activo/Inactivo)
```

### Validaciones
```java
if (!ValidadorDatos.esNumeroPositivo(precioBase)) {
    mostrarMensaje("El precio base debe ser positivo");
    return false;
}
```

---

## PLANTILLA GENÉRICA PARA CREAR ACTIVITIES

### ActividadListaXXX.java

```java
package com.example.goride.controlador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goride.R;
import com.example.goride.controlador.adaptadores.AdaptadorXXX;
import com.example.goride.modelo.entidades.XXX;
import com.example.goride.modelo.repositorio.RepositorioXXX;
import java.util.List;

public class ActividadListaXXX extends AppCompatActivity implements AdaptadorXXX.EventosXXX {
    
    private Button botonVolver;
    private Button botonCrear;
    private RecyclerView listaXXX;
    private RepositorioXXX repositorioXXX;
    private AdaptadorXXX adaptador;
    private List<XXX> items;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_xxx);
        
        repositorioXXX = new RepositorioXXX(this);
        inicializarVistas();
        configurarEventos();
        cargarItems();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        cargarItems();
    }
    
    private void inicializarVistas() {
        botonVolver = findViewById(R.id.botonVolver);
        botonCrear = findViewById(R.id.botonCrear);
        listaXXX = findViewById(R.id.listaXXX);
        listaXXX.setLayoutManager(new LinearLayoutManager(this));
    }
    
    private void configurarEventos() {
        botonVolver.setOnClickListener(v -> finish());
        botonCrear.setOnClickListener(v -> abrirFormularioCrear());
    }
    
    private void cargarItems() {
        items = repositorioXXX.obtenerTodos();
        adaptador = new AdaptadorXXX(items, this);
        listaXXX.setAdapter(adaptador);
    }
    
    private void abrirFormularioCrear() {
        Intent intent = new Intent(this, ActividadFormularioXXX.class);
        startActivity(intent);
    }
    
    @Override
    public void alEditar(XXX item) {
        Intent intent = new Intent(this, ActividadFormularioXXX.class);
        intent.putExtra("id", item.getId());
        startActivity(intent);
    }
    
    @Override
    public void alEliminar(XXX item) {
        new AlertDialog.Builder(this)
            .setTitle("Confirmar eliminación")
            .setMessage(getString(R.string.mensaje_confirmacion_eliminar))
            .setPositiveButton(getString(R.string.si), (dialog, which) -> {
                repositorioXXX.eliminar(item);
                mostrarMensaje(getString(R.string.mensaje_exito_eliminar));
                cargarItems();
            })
            .setNegativeButton(getString(R.string.no), null)
            .show();
    }
    
    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
```

---

## CHECKLIST POR MÓDULO

### Para cada nuevo módulo:

- [ ] Crear `activity_lista_xxx.xml`
- [ ] Crear `activity_formulario_xxx.xml`
- [ ] Crear `item_xxx.xml`
- [ ] Crear `ActividadListaXXX.java`
- [ ] Crear `ActividadFormularioXXX.java`
- [ ] Crear `AdaptadorXXX.java`
- [ ] Registrar activities en `AndroidManifest.xml`
- [ ] Actualizar método en `ActividadMenuPrincipal.java`
- [ ] Probar CREATE
- [ ] Probar READ
- [ ] Probar UPDATE
- [ ] Probar DELETE

---

## STRINGS.XML

Ya están definidos todos los strings necesarios en `res/values/strings.xml`:
- Títulos de módulos
- Campos de formularios
- Botones generales
- Mensajes de éxito/error
- Estados

---

## RECOMENDACIONES

1. **Empezar por el más simple:** Roles (solo 3 campos)
2. **Continuar con:** Servicios (5 campos)
3. **Después:** Conductores (7 campos + spinner)
4. **Finalizar con:** Viajes (10 campos + 3 spinners + cálculo)

5. **Reutilizar código:** Copiar las Activities de Usuarios y modificar lo necesario

6. **Mantener consistencia:** Usar los mismos nombres de métodos y variables

7. **Probar cada módulo:** Antes de pasar al siguiente

---

## EJEMPLO COMPLETO: IMPLEMENTAR MÓDULO DE ROLES

### 1. Crear activity_lista_roles.xml
Copiar `activity_lista_usuarios.xml` y cambiar:
- `textoTitulo` → "Gestión de Roles"
- `listaUsuarios` → `listaRoles`

### 2. Crear activity_formulario_rol.xml
```xml
<!-- Solo 2 campos + spinner estado -->
<TextInputEditText android:id="@+id/campoNombreRol" />
<TextInputEditText android:id="@+id/campoDescripcion" android:lines="3" />
<Spinner android:id="@+id/spinnerEstado" />
```

### 3. Crear item_rol.xml
```xml
<TextView android:id="@+id/textoNombreRol" />
<TextView android:id="@+id/textoDescripcion" />
<Button android:id="@+id/botonEditar" />
<Button android:id="@+id/botonEliminar" />
```

### 4. Crear ActividadListaRoles.java
Copiar `ActividadListaUsuarios.java` y:
- Reemplazar `Usuario` → `Rol`
- Reemplazar `RepositorioUsuario` → `RepositorioRol`
- Cambiar layout a `R.layout.activity_lista_roles`

### 5. Crear ActividadFormularioRol.java
Estructura similar pero solo 2 campos.

### 6. Crear AdaptadorRol.java
Similar a `AdaptadorUsuario.java` pero con campos de Rol.

### 7. Registrar en AndroidManifest.xml

### 8. Actualizar ActividadMenuPrincipal.java

---

## ARCHIVOS DE REFERENCIA

Todos los archivos del módulo de Usuarios están en:
```
controlador/ActividadListaUsuarios.java
controlador/ActividadFormularioUsuario.java
controlador/adaptadores/AdaptadorUsuario.java
res/layout/activity_lista_usuarios.xml
res/layout/activity_formulario_usuario.xml
res/layout/item_usuario.xml
```

Usar estos como plantilla y modificar según el módulo.

---

## CONCLUSIÓN

Con el módulo de Usuarios completamente implementado, tienes una **plantilla perfecta** para crear los 4 módulos restantes. Cada módulo sigue exactamente el mismo patrón, solo cambian:

1. Los campos del formulario
2. El tipo de entidad (Rol, Conductor, Viaje, Servicio)
3. Las validaciones específicas

El **Modelo ya está 100% completo** para todos los módulos. Solo falta crear las **Vistas** y **Controladores** siguiendo el patrón establecido.

---

**¡La base está sólida y lista para expandirse!**

