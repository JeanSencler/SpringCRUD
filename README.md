# spring-crud
API para CRUD con SPRING + Pruebas Unitarias

GET -- Todos los registros LOCALES
/countries

GET -- Todos los registros de API Externa  https://restcountries.com/
/countries/external

GET -- Obtener registro por ID 
/countries/{id}

POST -- Crear un registro LOCAL 
/countries 
  ejemplo de Body: 
                {
                  "countryName": "Pais Generico 1",
                  "state": "S"
                }
                
POST -- Actualizar Registro Local
/countries/{id}
  ejemplo de Body: 
                {
                  "countryName": "Pais Generico 1",
                  "state": "S"
                }
                
DELETE -- Borrar registro por ID 
/countries/{id}
