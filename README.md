# DataCrmAppJava
Prueba Tecnica Data Crm en Java

Realizado bajo Clean Architecture y Patron MVP
Java
RxJava y RxAndroid
ViewBinding 
MaterialComponent (CardView,RecyclerView)
Clean Architecture
Retrofit
Dagger 2

# Clean Architecture
Capas
- UI : Se encuentra toda la logica correspondiente a las vistas ,en este caso las activities con sus respectivos presenters

- Framework:  En esta capa se encontrara todo lo correspondiente al framework de Android,en este caso la libreria de Retrofit y la inyeccion de Dependencias con Dagger 2 sus Modulos y Componente 

- Data :Correspondiente a los datos de la aplicacion,repositorios y source(Intefaces),en este caso los repositorios de Login y Contacts con sus respectivos DataSource

- domain:Principalmente encontraremos el modelado de los objetos que se utilizaran en la aplicacion como por ejemplo Contact ,LoginUser ....

# Dagger 2 
La inyeccion de los repositorios y despues estos eran pasados como parametro al ViewModel

#Comunicacion
Se utilizo la implementacion de Observables con el cual se manejo el estado de los datos y se reacciona de acuerdo a ellos en el presenter 

