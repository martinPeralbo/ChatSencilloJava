package chatMonitorInterfaz;

public class ListaEnlazada {
	private Nodo inicio;
    private Nodo actual;
    private Nodo anterior;
    
    public  ListaEnlazada()
    {
        inicio=null;
    }
    
    public void insertarPrincipio(Object info)
    {
        Nodo nuevo = new Nodo(info,inicio);
        inicio=nuevo;
        anterior=null;
        actual=inicio;
    }
    
    public void irPrincipio()
    {
        //Asigna a actual y anterior valores coherentes. 
        anterior=null;
        actual=inicio;
    }
    
    public void insertarFinal(Object info)
    {
        Nodo nuevo=new Nodo(info,null);
        if(listaVacia())
            inicio=nuevo;
        else
            //me situo al final de la lista 
        {
            Nodo actual =inicio;
            while(actual.enlace!=null)
                actual=actual.enlace;
            //enlazar el ultimo nodo con el nuevo
            actual.enlace=nuevo;
        }
    }
    
    public boolean listaVacia()
    {
        return(inicio==null);
    }
    
    public void irSiguienteNodo()
    {
        anterior = actual;
        actual=actual.enlace;
        //Avanza al siguiente nodo actualizando las
        //referencias anterior y actual.
    }
    
    public Object getActual()
    {
        return actual.info;
        //Retorna la referencia del contenido del atributo inf del nodo.
    }
    
    public boolean finLista()
    {
        return (actual==null);
    }
           
    public void verLista()
    {
           //nos situamos al principio de la lista 
        /*while (actual!=null)
                {
                    System.out.println(actual.info); 
                    actual = actual.enlace;
                }*/
        for(irPrincipio();!finLista();irSiguienteNodo())
        {
            System.out.println(actual.info);
        }
        
    }
    
    public boolean eliminar(Object info)
    {
        //Recibe la referncia del objeto que quiere eliminar y retorna un bolean.
        Nodo actual=busquedaFor(info);
        boolean encontrado=false;
        if(actual!=null)
            encontrado=true;
            if(encontrado)
            {
               if(actual==inicio)
              inicio=inicio.enlace;
          else
            {
                //enlazamos el nodo anterior con el siguiente
              anterior.enlace=actual.enlace;
                return true;
            } 
            
          
            }
      return false;
        
    }

    public Nodo busquedaFor(Object info)
    {
        //Haceuna búsqueda con un bucle for y los métodos descritos anteriormente.
        for (irPrincipio();!finLista();irSiguienteNodo())
        {
            if(actual.info.equals(info))
               return actual;
       }
       return null;
    }
    
}
