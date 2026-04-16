# Sistema de Administración de Citas Médicas

Este proyecto es una aplicación en Java que simula un sistema de administración de citas para un consultorio clínico.  
Permite registrar doctores, pacientes, crear citas médicas y relacionarlas, además de contar con control de acceso mediante administradores.

---
# Evidencia Final SCM

## Resumen Ejecutivo

### Descripción
Este proyecto corresponde a la Evidencia Final de la materia **Software Configuration Management (SCM)**. Su propósito es demostrar la correcta aplicación de prácticas de control de versiones, documentación técnica, gestión de configuración y despliegue básico de una solución de software.

### Problema identificado
En muchos proyectos académicos y profesionales, la falta de control de versiones, documentación clara y procesos de instalación/configuración provoca errores, pérdida de información y dificultades para colaborar en equipo.

### Solución
Este proyecto implementa una estructura formal de documentación, control de versiones con Git y GitHub, lineamientos de contribución, y una guía completa para instalación, configuración y uso del sistema. Esto permite mantener orden, trazabilidad y claridad en el ciclo de vida del software.

### Arquitectura
Arquitectura conceptual del proyecto:
- **Backend:** Java (estructura base para demostración SCM)
- **Gestión de dependencias:** Maven
- **Base de datos:** H2 (local) o PostgreSQL (producción)
- **Control de versiones:** Git + GitHub
- **Despliegue:** Local o nube (Heroku)

---

## Tabla de Contenidos
- [Resumen Ejecutivo](#resumen-ejecutivo)
- [Requerimientos](#requerimientos)
- [Instalación](#instalación)
- [Cómo instalar dependencias](#cómo-instalar-dependencias)
- [Configuración](#configuración)
- [Uso](#uso)
- [Contribución](#contribución)
- [Roadmap](#roadmap)

---

## Requerimientos

### Servidores
- Servidor embebido de Spring Boot (no requiere instalación adicional)
- Opcional: Heroku para despliegue en la nube

### Bases de datos
- H2 Database (modo local)
- PostgreSQL (modo producción)

### Paquetes adicionales
- Spring Web
- Spring Data JPA
- Lombok (opcional)
- H2 Database Driver

### Versiones
- **Java 17**
- **Maven 3.8+**
- **Git 2.0+**

---

## Instalación

### 1. Clonar el repositorio
```bash
git clone https://github.com/minipocCC/Evidencia-Final-SCM.git
cd Evidencia-Final-SCM


## Instalación y configuración

### Requisitos previos

- JDK 11 instalado y configurado en el sistema.
- IDE Java (por ejemplo, NetBeans).
- Git instalado.
- Cuenta en GitHub.

### Pasos de instalación

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/USUARIO/NOMBRE-DEL-REPO.git
   ## Licencia

Este proyecto fue desarrollado con fines académicos como parte de la evidencia final del curso de Computación en Java de la Universidad Tecmilenio.  
El código puede ser utilizado únicamente con propósitos educativos y no comerciales, respetando los lineamientos y políticas de la institución.
## Créditos

- **Autora:** SCM
- **Curso:** Computación en Java  
- **Institución:** Universidad Tecmilenio  
- **Profesor:** Silvia Tello 
