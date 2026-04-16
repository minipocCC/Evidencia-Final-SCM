# Evidencia Final SCM

## Resumen Ejecutivo

### Descripción
Este proyecto corresponde a la Evidencia Final de la materia **Software Configuration Management (SCM)**. Su propósito es demostrar la correcta aplicación de prácticas de control de versiones, documentación técnica, gestión de configuración y despliegue básico de una solución de software. El proyecto consiste en un sistema de administración de citas médicas desarrollado en Java, utilizando archivos CSV como almacenamiento local.

### Problema identificado
En muchos proyectos académicos y profesionales, la falta de control de versiones, documentación clara y procesos de instalación/configuración provoca errores, pérdida de información y dificultades para colaborar en equipo. Además, los sistemas de citas médicas suelen carecer de organización, lo que genera confusión, duplicidad de registros y mala administración del tiempo.

### Solución
Este proyecto implementa una estructura formal de documentación, control de versiones con Git y GitHub, lineamientos de contribución, y una guía completa para instalación, configuración y uso del sistema. Además, se desarrolla un sistema de citas médicas que permite registrar pacientes, doctores y citas, almacenando la información en archivos CSV para facilitar su consulta y mantenimiento.

### Arquitectura
Arquitectura conceptual del proyecto:
- **Backend:** Java (programación orientada a objetos)
- **Almacenamiento:** Archivos CSV
- **Control de versiones:** Git + GitHub
- **Ejecución:** Consola / IDE (NetBeans, IntelliJ, VSCode)
- **Despliegue:** Local

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
- No requiere servidor externo (aplicación local)
- Ejecución mediante consola o IDE

### Bases de datos
- Archivos CSV:
  - `pacientes.csv`
  - `doctores.csv`
  - `citas.csv`

### Paquetes adicionales
- Ninguno (solo librerías estándar de Java)

### Versiones
- **Java 17** (recomendado)
- **Git 2.0+**
- **IDE recomendado:** NetBeans / IntelliJ / VSCode

---

## Instalación

### 1. Clonar el repositorio
```bash
git clone https://github.com/minipocCC/Evidencia-Final-SCM.git
cd Evidencia-Final-SCM
