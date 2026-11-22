/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import model.*;
import view.GUI_VistaJuegoPlataformas;

/**
 *
 * @author aaron
 */
public class ControladorJuegoPlataformas implements ActionListener,KeyListener{
    private Juego game = new Juego();
    private GUI_VistaJuegoPlataformas view = new GUI_VistaJuegoPlataformas();
    private Timer reloj = new Timer(16, this);
    private boolean izq,der=false;
    
    public ControladorJuegoPlataformas()
    {
        reloj.setActionCommand("TICK");
        view.addJuegoListener(this);
        view.addTecladoListener(this);
    }
    
    public void iniciar()
    {
        view.construirEscena(game);
        view.mostrarMensaje("Recoge los bloques y llévalor a su definición");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.requestFocus();
        reloj.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case "TICK":
                game.mover((der ? 1 :0)-(izq?1:0));
                game.actualizar();
                view.actualizar(game);
                break;
            case "REINICIAR":
                game.reiniciar();
                view.construirEscena(game);
                view.mostrarMensaje("Nivel reiniciado");
                break;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                izq=true;
                break;
            
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                der=true;
                break;
                
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
            case KeyEvent.VK_SPACE:
                game.saltar();
                break;
                
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                game.agachar(true);
                break;
                
            case KeyEvent.VK_E:
                view.mostrarMensaje(game.accion());
                break;
                
            case KeyEvent.VK_R:
                game.reiniciar();
                view.construirEscena(game);
                view.mostrarMensaje("NIVEL REINICIADO");
                break;
                
            case KeyEvent.VK_0:
                System.exit(0);
                break;

        }
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                izq=false;
                break;
            
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                der=false;
                break;
                
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                game.agachar(false);
                break;

        }
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }
}