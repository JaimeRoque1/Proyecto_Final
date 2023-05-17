/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

/**
 *
 * @author Elizabeth
 */

import com.sun.opengl.util.Animator;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import java.io.File;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import org.yourorghere.DrawStan;
import static org.yourorghere.Main.jMenuBar;

import javax.swing.JMenuBar;

public class Main implements GLEventListener, MouseListener, MouseMotionListener,MouseWheelListener, KeyListener{
    public static int bnd=0;
    
    public static final JMenuBar jMenuBar = new JMenuBar();
    public static final JMenu jMOriginal = new JMenu();
    public static final JMenu jMtraslacion = new JMenu();
    public static final JMenu jMEscalacionA = new JMenu();

    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    boolean[] keys=new boolean[256]; //to know which key is pressed
    
    //position of stan in the window
    private static final float X_POSITION=0f;
    private static final float Y_POSITION=-0.08f;
    private static final float Z_POSITION=0f;

    
     private Texture cara1, cara2,cara3,cara4, cara5,cara6;
     private Texture cara1_2, cara2_2,cara3_2,cara4_2, cara5_2,cara6_2;
     private Texture cara1_3, cara2_3,cara3_3,cara4_3, cara5_3,cara6_3;
     private Texture cara1_4, cara2_4,cara3_4,cara4_4, cara5_4,cara6_4;
     private Texture cara1_5, cara2_5,cara3_5,cara4_5, cara5_5,cara6_5;
     private Texture cara1_6, cara2_6,cara3_6,cara4_6, cara5_6,cara6_6;
     private Texture cara1_7, cara2_7,cara3_7,cara4_7, cara5_7,cara6_7;

    //position of stan in the window
   
    
    private double zoom = 5;
    
    public static void main(String[] args){
        
        JFrame frame = new JFrame("Trivia Halcon: Seleccion de personaje: '1' , '2' o '3'");
        jMOriginal.setText("Personaje 1");
        jMenuBar.add(jMOriginal);
        jMtraslacion.setText("Personaje 2");
        jMenuBar.add(jMtraslacion);
        jMEscalacionA.setText("Personaje 3");
        jMenuBar.add(jMEscalacionA);
        
        jMOriginal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                JMOriginalMouseClicked(evt);
            }

            private void JMOriginalMouseClicked(MouseEvent evt) {
            bnd = 1; 
            }
        });
        jMtraslacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                JMTraslacionMouseClicked(evt);
            }

            private void JMTraslacionMouseClicked(MouseEvent evt) {
            bnd = 2; 
            }
        });
        
        jMEscalacionA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                JMEscalacionAMouseClicked(evt);
            }

            private void JMEscalacionAMouseClicked(MouseEvent evt) {
            bnd = 3; 
            }
        
        });
        
         
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new Main());
        frame.add(canvas);
        frame.setSize(1000, 800);
        frame.setJMenuBar(jMenuBar);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {
                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
          
    }

    public void init(GLAutoDrawable drawable){
        
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.setSwapInterval(1);
        
        // set up lighting
        float light_ambient[]={0.9f, 0.9f, 0.9f, 1.0f};
        float light_diffuse[]={0.3f, 0.3f, 0.3f, 1.0f};
        float light_specular[]={1.0f, 1.0f, 1.0f, 1.0f};
        float light_position[] = {1.0f,1.5f,1.0f,0.0f };
        
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);
        
        gl. glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);
            
        // Setup the drawing area and shading mode
        gl.glClearColor(0.9f, 0.9f, 0.9f, 0.9f); 
        gl.glShadeModel(GL.GL_SMOOTH);
        try {
            //Se indica la localizacion de la figura
           
            cara1 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario1.jpg"), true);            
            cara2 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario1.jpg"), true);            
            cara3 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario1.jpg"), true);       
            cara4 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario1.jpg"), true);       
            cara5 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario1.jpg"), true);       
            cara6 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario1.jpg"), true);      
            
            cara1_2 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario2.jpg"), true);            
            cara2_2 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario2.jpg"), true);            
            cara3_2 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario2.jpg"), true);       
            cara4_2 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario2.jpg"), true);       
            cara5_2 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario2.jpg"), true);       
            cara6_2 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario2.jpg"), true);
            
            cara1_3 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario3.jpg"), true);            
            cara2_3 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario3.jpg"), true);            
            cara3_3 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario3.jpg"), true);       
            cara4_3 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario3.jpg"), true);       
            cara5_3 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario3.jpg"), true);       
            cara6_3 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario3.jpg"), true);
            
            cara1_4 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario4.png"), true);            
            cara2_4 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario4.png"), true);            
            cara3_4 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario4.png"), true);       
            cara4_4 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario4.png"), true);       
            cara5_4 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario4.png"), true);       
            cara6_4 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario4.png"), true);
            
            cara1_5 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario5.jpg"), true);            
            cara2_5 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario5.jpg"), true);            
            cara3_5 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario5.jpg"), true);       
            cara4_5 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario5.jpg"), true);       
            cara5_5 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario5.jpg"), true);       
            cara6_5 = TextureIO.newTexture(new File("src/org/yourorghere/Escenario5.jpg"), true);
            
            }   catch (IOException e) {
                System.err.print("No se puede cargar textura" + e);
                System.exit(1);
            }
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);
        drawable.addMouseWheelListener(this);
            
    }
    
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height){
        
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) { // avoid a divide by zero error!
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        
    }
    
    public void display(GLAutoDrawable drawable){
        
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        glu.gluLookAt(0.1f,0.0f,zoom,// eye
                      0.0f,0.0f,0.0f,  // looking at
                      0.0f,0.0f,1.0f   // is up
                    );
        
        // Move the whole scene
        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        gl.glRotatef(view_rotx,1.0f,0.0f,0.0f);
        gl.glRotatef(view_roty,0.0f,1.0f,0.0f);
        gl.glRotatef(90,0.0f,0.0f,1.0f);
        
        //gl.glRotated(90, 0f, 0f, 1f);
        //gl.glTranslatef(-3f,0f,0f);
        cara1.enable();//habilitamos
            cara1.bind();//pegamos
                      
            gl.glBegin(gl.GL_QUADS);                                            
                
                gl.glTexCoord2f(1, 1);                
                gl.glVertex3f(10, 10, 0);     
                
                gl.glTexCoord2f(0, 1);
                gl.glVertex3f(-10f, 10f, 0);
                
                gl.glTexCoord2f(0, 0);
                gl.glVertex3f(-10f, 10f, 10);
                
                gl.glTexCoord2f(1, 0);
                gl.glVertex3f(10f, 10f, 10);                                                                                                                                                                                                                                    
            gl.glEnd();
            cara1.disable();//desabilitar
                        
            cara2.enable();
            cara2.bind();
            //Cara 2  Verde
            gl.glBegin(gl.GL_QUADS);
                gl.glTexCoord2f(1, 1);
                gl.glVertex3f(10f, -10, 0);
                
                gl.glTexCoord2f(0, 1);
                gl.glVertex3f(10f, 10f, 0);
                
                gl.glTexCoord2f(0, 0);
                gl.glVertex3f(10f, 10f, 10f);
                
                gl.glTexCoord2f(1, 0);
                gl.glVertex3f(10f, -10f,10f);                                
            gl.glEnd();
            cara2.disable();
            
            cara3.enable();
            cara3.bind();
            //Cara 3  Amarillo       
            gl.glBegin(gl.GL_QUADS);                
                gl.glTexCoord2f(1, 1);
                gl.glVertex3f(-10f, -10f, 0f);
                
                gl.glTexCoord2f(0, 1);
                gl.glVertex3f(10f, -10f, 0f);
                
                gl.glTexCoord2f(0, 0);
                gl.glVertex3f(10f, -10f,10f);                
                
                gl.glTexCoord2f(1, 0);
                gl.glVertex3f(-10f, -10f, 10f);
            gl.glEnd();
            cara3.disable();
                        
            //Cara 4  ROJO
            cara4.enable();
            cara4.bind();
            gl.glBegin(gl.GL_QUADS);                
                gl.glTexCoord2f(0, 0);
                gl.glVertex3f(-10f, 10, 0f);                               
                                
                gl.glTexCoord2f(1, 0);
                gl.glVertex3f(-10f, -10f,0f);                
                                
                gl.glTexCoord2f(1, 1);
                gl.glVertex3f(-10f, -10f, 10f);                                                
                
                gl.glTexCoord2f(0, 1);
                gl.glVertex3f(-10f, 10f, 10f);
            gl.glEnd();
            cara4.disable();
            
            //Cara 5  Verde Fuerte
            cara5.enable();
            cara5.bind();
            gl.glBegin(gl.GL_QUADS);
                gl.glTexCoord2f(1, 1);
                gl.glVertex3f(10f, 10f, 0f);
                
                gl.glTexCoord2f(0, 1);
                gl.glVertex3f(-10f, 10f, 0f);
                
                gl.glTexCoord2f(0, 0);
                gl.glVertex3f(-10f, -10f,0f);
                
                gl.glTexCoord2f(1, 0);
                gl.glVertex3f(10f, -10, 0f);                                                
            gl.glEnd();
            cara5.disable();
            
            //Cara 6  morado
            cara6.enable();
            cara6.bind();
            gl.glBegin(gl.GL_QUADS);
                gl.glTexCoord2f(1, 1);
                gl.glVertex3f(10f, 10f, 10f);
                
                gl.glTexCoord2f(0, 1);
                gl.glVertex3f(-10f, 10f, 10f);
                
                gl.glTexCoord2f(0, 0);
                gl.glVertex3f(-10f, -10f,10f);
                
                gl.glTexCoord2f(1, 0);
                gl.glVertex3f(10f, -10, 10f);
            gl.glEnd();
            cara6.disable();
        
         
            
                bnd = 0;
                DrawStan1 p = new DrawStan1(); 
                       
                DrawStan s = new DrawStan(); 
        
              DrawDingo din = new DrawDingo();
           bnd = 4;
        if (keys['1']) {
            bnd = 1;
        }else if (keys ['2']){
           bnd = 2;
        }else if (keys ['3']){
          bnd = 3;
        }//else if (keys ['4']){
         // bnd = 4;
        //}     
        switch(bnd){
            
            case 1:
                //DrawStan1 p = new DrawStan1(); 
        p.draw_stan1(gl, keys['W'], keys['J'],keys['A'], keys['S'],keys['D'],keys['I'],keys['E']);    
        
                break;
            case 2:
                //DrawStan_1 s = new DrawStan_1(); 
        s.draw_stan(gl, keys['W'], keys['J'],keys['A'], keys['S'],keys['D'],keys['I'],keys['E'],keys['O']); 
         break;
            case 3:
              //DrawDingo din = new DrawDingo();
        din.draw_dingo(gl, keys['W'], keys['J'], keys['P'], keys['D'], keys['S'],
               keys['L'], keys['O']);
                break;
            case 4:
                 gl.glPopMatrix();
                  gl.glPopMatrix();
         
                   
                  
        gl.glPushMatrix();
        gl.glTranslatef(0f,0f,0f);
        p.draw_stan1(gl, false,false,false,false,false,false,false);    
        gl.glPopMatrix();
       
        
        gl.glPushMatrix();
        gl.glTranslatef(2f, 0.0f, 0f);
        s.draw_stan(gl, false,false,false,false,false,false,false,false); 
        gl.glPopMatrix();
    
        gl.glPushMatrix();
        gl.glTranslatef(-2f, 0.0f, 0f);
       din.draw_dingo(gl, false,false,false,false,false,false,false);
        gl.glPopMatrix();
   
              
                
                 
                break;
        }
        gl.glFlush();
                       
        /**/
         
        //gl.glTranslatef(3f,0f,0f);
        
        
            //JOptionPane.showMessageDialog ( null , "Acerca de: Autor: Jaime Gabriel Roque Zepeda" );
        
        
        //caja((GLAutoDrawable) gl, keys['W'], keys['J'],keys['A'], keys['S'],keys['D']);
        
//we draw Stan in the window
        
        
        // Flush all drawing operations to the graphics card
        
    }
    
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged){}
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
    public void keyTyped(KeyEvent e){}   
    public void keyReleased(KeyEvent e){}
    
    
    public void mousePressed(MouseEvent e){
        oldMouseX = e.getX();
        oldMouseY = e.getY();     
    }
    
    public void mouseDragged(MouseEvent e){
        
        int x = e.getX();
        int y = e.getY();
        Dimension size = e.getComponent().getSize();
        float thetaX = 360.0f * ( (float)(x-oldMouseX)/(float)size.width);
        float thetaY = 360.0f * ( (float)(oldMouseY-y)/(float)size.height);
        oldMouseX = x;
        oldMouseY = y;
        view_rotx += thetaX;
        view_roty += thetaY;
   
    }
    
    
    
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode()<250 && keys[e.getKeyCode()]==false){
            keys['W']=false;
            keys['J']=false;
            keys['A']=false;
            keys['S']=false;
            keys['D']=false;
            keys['I']=false;
            keys['E']=false;
            keys['O']=false;
            keys['1']=false;
            keys['2']=false;
            keys['3']=false;
            keys['4']=false;
            keys[e.getKeyCode()]=true;    
        }
        else
            keys[e.getKeyCode()]=false;    
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
    int gira = e.getWheelRotation();
        if (gira < 0) {
            zoom -= 0.1;
        }else   {
            zoom += 0.1;
        }
    }
}