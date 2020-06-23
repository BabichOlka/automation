package com.solvd.automation.lab.transport;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class TransportFactory {
    public static Car getTransportbyName(String name){
       String carPath = name;
        switch (name){
        case "Transport.BMW": return getBMW(carPath);
        case "Transport.Volvo": return getVolvo(carPath);
        case "Transport.Opel": return getOpel(carPath);
        default: return getDefaultCar(carPath);

         }
    }
    public static Car getDefaultCar (String carInput){

      Class<?> curClass;

        try{ curClass = Class.forName("transport."+carInput);
          //  Engine engine = new Engine();
           // Wheels wheels = new Wheels();
            Class[] param ={String.class, Engine.class, Wheels.class, Point.class};
            return (Car) curClass.getConstructor(param)
                    .newInstance("Defoltclass",new Engine("DE",20),new Wheels("Dw",Math.random()),null);
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException| NoSuchMethodException | InvocationTargetException e ){
            e.printStackTrace();}
        return null;
        } ;


    public static BMW getBMW(String carInput){

        Class<?> curClass;

        try{ curClass = Class.forName("transport." + carInput);
            Class[] param ={String.class, Engine.class, Wheels.class, Point.class};
            return (BMW) curClass.getConstructor(param)
                    .newInstance("Transport.BMW",new Engine("BMWE",20),
                            new Wheels("BMWw",Math.random()),null);
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException| NoSuchMethodException | InvocationTargetException e ){
            e.printStackTrace();}
        return null;



    }
    public static Volvo getVolvo(String carInput){

        Class<?> curClass;

        try{ curClass = Class.forName("transport." + carInput);
            Class[] param ={String.class, Engine.class, Wheels.class, Point.class};
            return (Volvo) curClass.getConstructor(param)
                    .newInstance("Transport.Volvo",new Engine("VolvoE",30),new Wheels("Volvow",Math.random()) ,null);
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException| NoSuchMethodException | InvocationTargetException e ){
            e.printStackTrace();}
        return null;



    }
    public static Opel getOpel(String carInput){

        Class<?> curClass;

        try{ curClass = Class.forName("transport." + carInput);
            Class[] param ={String.class, Engine.class, Wheels.class, Point.class};
            return (Opel) curClass.getConstructor(param)
                    .newInstance("Transport.Opel",new Engine("OpelE",15),new Wheels( "Opelw",Math.random()),null);
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException| NoSuchMethodException | InvocationTargetException e ){
            e.printStackTrace();}
        return null;



    }
    }

