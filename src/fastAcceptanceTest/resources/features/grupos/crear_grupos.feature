# language: es

Característica: Crear Grupo para repartir gastos

  Regla: Los grupos están compuestos por al menos dos miembros

    Escenario: No puedo crear un grupo con un único miembro
      Cuando el usuario intenta crear un grupo indicando un único miembro
      Entonces no debería crear el grupo con un único miembro

  Regla: El total de gastos de un grupo debe ser positivo

    Escenario: No puedo crear un grupo con un total de gastos negativo
      Cuando el usuario intenta crear un grupo con un total de gastos negativo
      Entonces no debería crear el grupo con un total de gastos negativo
