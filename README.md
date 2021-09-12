## CRUD desarrollado en Spring Boot

Hay varios commits que aparecen a la misma hora, creo que se debe a que usé un `git rebase` para corregir dos mensajes de commit, pero todo fue hecho incrementalmente.
Se implementó manejo de errores para que las acciones listar por id, editar y eliminar arrojen un error 404 not found cuando se aplican a ids inexistentes.
Los endpoints de la api son:

1. `localhost:8080/api/personas`  : Lista todas las personas en la base de datos
2. `localhost:8080/api/persona` : Guarda una persona
3. `localhost:8080/api/persona/{id}`:  Método DELETE - Elimina el registro con el id {id}
4. `localhost:8080/api/persona/{id}`: Método GET - Lista la persona con el id {id}
5. `localhost:8080/api/persona/{id}`: Método PUT - Actualiza la persona con el id {id}
