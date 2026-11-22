/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class Juego {
    //CLASE ENCARGADA DE LOS FUNCIONAMIENTOS DEL JUEGO
    //variables
    private int ancho=900;
    private int alto=560;
    
    private double gravedad=0.6;
    private int velocidad=4;
    private double salto=-12;
    
    private Jugador player;
    //ARRAYLIST
    private ArrayList<ContenidoBloque> bloques = new ArrayList<>();
    private ArrayList<CuadroDefinicion> zonas = new ArrayList<>();
    private ArrayList<Rectangle> plataformas = new ArrayList<>();
    
    private int puntaje;
    private boolean terminado;

    public Juego() {
        crearNivel();
    }
    
    private void crearNivel()
    {
        player = new Jugador(30,472);
        puntaje=0;
        terminado=false;
        
        plataformas.clear();
        plataformas.add(new Rectangle(0, 520, ancho,40)); //el suelo
        plataformas.add(new Rectangle(80, 430, 150,14));
        plataformas.add(new Rectangle(300, 350, 150,14));
        plataformas.add(new Rectangle(520, 430, 150,14));
        plataformas.add(new Rectangle(720, 350, 150,14));
        plataformas.add(new Rectangle(520, 270, 150,14));
        plataformas.add(new Rectangle(300, 190, 150,14));
        
        zonas.clear();
        zonas.add(new CuadroDefinicion(Bloque.bloqueIf,20,450));
        zonas.add(new CuadroDefinicion(Bloque.bloqueIfElse,350,450));
        zonas.add(new CuadroDefinicion(Bloque.bloqueSwitch,680,450));
        
        bloques.clear();
        bloques.add(new ContenidoBloque(Bloque.bloqueIf,750,320));
        bloques.add(new ContenidoBloque(Bloque.bloqueIf,550,240));
        bloques.add(new ContenidoBloque(Bloque.bloqueIfElse,330,320));
        bloques.add(new ContenidoBloque(Bloque.bloqueIfElse,250,490));
        bloques.add(new ContenidoBloque(Bloque.bloqueSwitch,110,400));
        bloques.add(new ContenidoBloque(Bloque.bloqueSwitch,550,400));
        
    }
    
    public void reiniciar()
    {
        crearNivel();
    }
    
    //MOVIMIENTOS
    public void mover(int direccion)
    {
        int velocidadMovimiento= player.isAgachado() && player.isEnSuelo() ? velocidad/2 : velocidad;
        
        player.setVelocidadX(direccion*velocidadMovimiento);
        if(direccion!=0)
        {
            player.setDireccion(direccion);
        }
        
    }
    
    public void agachar(boolean agachado)
    {
        player.setAgachado(agachado);
    }
    
    //SALTOS
    public void saltar()
    {
        if(player.isEnSuelo())
        {
            player.setVelocidadY(salto);
            player.setEnSuelo(false);
            player.setSaltosUsados(1);
            player.setAcrobatico(false);
            player.setTicksEnAire(0);
        }
        else if(player.getSaltosUsados()<2)
        {
            player.setVelocidadY(salto*0.9);
            player.setSaltosUsados(2);
            player.setAcrobatico(true);
            player.setTicksEnAire(0);
        }
    }
    
    public void actualizar()
    {
        if(terminado)
        {
            return;
        }
        
        //NEW X
        int newX = player.getX()+player.getVelocidadX();
        newX = Math.max(0, Math.min(ancho - Jugador.ancho, newX));
        player.setX(newX);
        
        boolean newEnSuelo = player.isEnSuelo();
        int parteBajaAnterior = player.getY()+ Jugador.alto;
        player.setVelocidadY(player.getVelocidadY()+gravedad);
        player.setY(player.getY()+ (int) Math.round(player.getVelocidadY()));
        player.setEnSuelo(false);
        
        if(player.getVelocidadY()>=0)
        {
            int newParteBaja =player.getY()+Jugador.alto;
            for(Rectangle p : plataformas)
            {
                boolean arribaHorizontal = player.getX() + Jugador.ancho > p.x && player.getX() < p.x + p.width;
                
                if(arribaHorizontal && parteBajaAnterior <= p.y && newParteBaja >= p.y)
                {
                    player.setY(p.y-Jugador.alto);
                    player.setVelocidadY(0);
                    player.setEnSuelo(true);
                    break;
                }
            }
            
            //ESTADO DE LA ANIMACION
            player.setTicksAnimacion(player.getTicksAnimacion()+1);
            
            if(player.isEnSuelo())
            {
                player.setSaltosUsados(0);
                player.setAcrobatico(false);
                player.setTicksEnAire(0);
            }
            else
            {
                if(newEnSuelo && player.getSaltosUsados()==0)
                {
                    player.setSaltosUsados(1);
                    player.setTicksEnAire(24);
                }
                player.setTicksEnAire(player.getTicksEnAire()+1);
            }
            
            //BLOQUE CARGADO
            ContenidoBloque cargado = player.getBloqueCargado();
            if(cargado!=null)
            {
                cargado.setPosicion(player.getX()+(Jugador.ancho-ContenidoBloque.ancho)/2, player.getY()+ContenidoBloque.alto-14);
            }

        }
    }
    
    //FUNCION DE RECOGER Y COLOCAR
    public String accion()
    {
        if (terminado)
        {
            return "¡Juego Terminado! Presiona R para reiniciar.";
        }
        
        if(player.getBloqueCargado() == null)
        {
            return recoger();
        }
        return colocar();
    }
    
    public String recoger()
    {
        for(ContenidoBloque b : bloques)
        {
            if(!b.isBloqueColocado() && b.getArea().intersects(player.getArea()))
            {
                b.setBloqueCargado(true);
                player.setBloqueCargado(b);
                
                return "Recogiste el bloque: "+ b.getTipoBloque().getTxt();
            }
        }
        return "No quedan bloques cerca";
    }
    
    private String colocar()
    {
        ContenidoBloque b = player.getBloqueCargado();
        
        for(CuadroDefinicion c : zonas)
        {
            if(c.getArea().intersects(player.getArea()))
            {
                player.setBloqueCargado(null);
                b.setBloqueColocado(false);
                
                if(c.getTipoBloque() == b.getTipoBloque())
                {
                    b.setPosicion(c.getX()+5 + c.getColocado() * (ContenidoBloque.ancho+5), c.getY()+35);
                    b.setBloqueColocado(true);
                    c.agregarBloque();
                    
                    puntaje+=10;
                    
                    if(todosColocados())
                    {
                        terminado = true;
                        return "¡Terminaste el juego! Puntaje final: "+puntaje+""
                                + "\n(R para reiniciar)";
                    }
                    return "¡Correcto! +10 puntos";
                }
                
                b.reiniciar();
                puntaje = Math.max(0, puntaje-5);
                return "Este bloque no pertenece aquí, volvió a su lugar. -5 puntos";
            }
        }
        return "Ponte sobre una definición para colocar el bloque,";
    }
    
    public boolean todosColocados()
    {
        for (ContenidoBloque b : bloques)
        {
            if(!b.isBloqueColocado())
            {
                return false;
            }
        }
        return true;
    }
    
    //GETS

    public Jugador getPlayer() {
        return player;
    }

    public ArrayList<ContenidoBloque> getBloques() {
        return bloques;
    }

    public ArrayList<CuadroDefinicion> getZonas() {
        return zonas;
    }

    public ArrayList<Rectangle> getPlataformas() {
        return plataformas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public boolean isTerminado() {
        return terminado;
    }
    
}
/*

*/