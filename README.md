# 🗄️ JPA con Auditoría de Cambios

Extensión del proyecto de persistencia JPA que incorpora **auditoría automática de cambios** en las entidades. Permite registrar y consultar el historial de modificaciones sobre los datos almacenados en H2.

## 🛠️ Tecnologías

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)

**Dependencias:** JPA (Hibernate), H2 Database, Hibernate Envers, Gradle

## 📋 Funcionalidades

- Persistencia de entidades con JPA/Hibernate
- **Auditoría de cambios** con Hibernate Envers: registra cada modificación (insert, update, delete)
- Consulta del historial de revisiones de una entidad
- Modo `create` y `update` en `persistence.xml` para distintos escenarios

## 🚀 Cómo ejecutar

**Requisitos:** IntelliJ IDEA, H2 Database instalado

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/MannMatias/java-jpa-auditory
   ```
2. Abrir en IntelliJ IDEA: `File > Open` → seleccionar la carpeta del proyecto
3. Iniciar el servidor H2 (`h2.bat` o `h2.sh`)
4. Conectarse a la consola H2:
   - **JDBC URL:** `jdbc:h2:tcp://localhost/~/test`
   - **User:** `sa` | **Password:** *(vacío)*
5. Ejecutar `Main.java`
6. Para probar la auditoría: comentar la sección de creación en `Main.java`, descomentar el bloque de actualización, y cambiar `"create"` por `"update"` en `persistence.xml`

## 📚 Contexto

Proyecto desarrollado para la materia **Desarrollo de Software** — UTN FRM.
