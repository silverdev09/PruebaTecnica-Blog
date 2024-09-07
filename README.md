# PruebaTecnica-Blog 

Prueba Técnica - Desarrollador Soluciones Back End: APIs Rest que permite la  gestión de blogs. 

Para implementar solucion de la prueba tecnica, la estrategia que se utilizó para exponer API REST fue crear un Proyecto Maven denominado PruebaTecnica-Blog, que tiene los siguiente paquetes:
1. blog.dao: En este paquete se encuentra la clase que permite la interaccion con la base de datos mediante JPA bajo el Framework Hibernate.
             Se usa JPA como especificacion y programar contra la especificacion usando EntityManager, se usa anotaciones del estandar de JPA.    
    
2. blog.entity: En este paquete se encuentra las tablas mapeados a traves de los entities.
3. blog.impl: En este paquete se encuentra la parte de la logica de negocio y el control de errores a traves de las excepciones.
4. blog.serv: Aqui se encuentra el nexo o la interface entre los APIs y la implementacion.

La clase que expone los APIs Rest se denomina BlogService.java, mismo se encuentra en el paquete blog desde el cual se realiza las solicitudes HTTP utiizando el componente WebServlet para ejecutar en el servidor de una web. 

La documentación de las APIs se encuentra en este mismo proyecto PruebaTecnica-Blog\documentacion api\Documentacion de APIs de Blogs.docx