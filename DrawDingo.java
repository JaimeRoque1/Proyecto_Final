/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

/**
 *
 * @author Vane
 */

import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class DrawDingo {
    
    //precision and global variables
    private static final int SLICES=40;
    private static final int STACKS=40;
    private GLUquadric q=null;
    private static int mvt=0;
    
    //heigth and widht of each components
    private static final float HEIGHT_BODY=0.9f;
    private static final float TOP_BODY=0.4f;
    private static final float BOTTOM_BODY=0.40f;
    private static final float HEIGHT_LEGS=0.2f;
    private static final float WIDTH_LEGS=0.185f;
    private static final float HEIGHT_ARMS=0.22f;
    private static final float WIDTH_ARMS=0.09f;
    private static final float WIDTH_HEAD=0.01f;
    private static final float HEIGHT_HEAD=1.0f;
    private static final float WIDTH_EYES=0.18f;
    private static final float WIDTH_HANDS=0.1f;
    private static final float WIDTH_FINGERS=0.0525f;
    private static final float WIDTH_SHOES=0.28f;
    private static final float HEIGHT_SHOES=0.05f;
    private static final float WIDTH_OPEN_MOUTH=0.1f;
    private static final float WIDTH_BUTTONS=0.0525f;
    private static final float SPACE_BETWEEN_BUTTONS=0.12f;
    private static final float WIDTH_BOTTOM_BONNET=0.525f;
    private static final float HEIGHT_BOTTOM_BONNET=0.12f;
    private static final float WIDTH_BONNET=1.0f;
    private static final float WIDTH_PUPILS=0.03f;
    private static final float WIDTH_POMPON=0.12f;
    
    //position of each component int the window
    public DrawDingo(){}
    
//MOVIMIENTOS
//    walk = caminar W
//    jump = saltar J
//    kick = patear P
//    defend = defender D
//    greet = saludar S
//    FALTAN DOS MOVIMIENTOS
//     L =
//    O =
//EXPRESIONES
//    confuse = confundido C
//    angry = enojo A
//    happy = feliz H
//    serious = serio F
//    surprise = sorprendido G
//    dislike = disgusto
//    sad = tristeza T
//     
    public void draw_dingo (GL gl, boolean confuse, boolean angry, boolean happy, boolean serious
                            , boolean surprise, boolean dislike, boolean sad){
        
//    public void draw_dingo (GL gl, boolean walk, boolean jump, boolean kick, boolean defend,
//            boolean greet,boolean confuse, boolean angry, boolean happy, boolean serious,
//            boolean surprise, boolean dislike, boolean sad, boolean L, boolean O){
        
        GLU glu = new GLU();
        q=glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        
//        //Stan is walking
//        if(walk && mvt%20+10>20){
//            draw_legs(gl, glu, 'W', false);
//            draw_legs(gl, glu, ' ', true);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, 'W');
//            draw_head (gl, glu, false,false,false,false,false,false,false,false,false,false);
//        }
//        else if(walk && mvt%20+10<=20){
//            draw_legs(gl, glu, ' ', false);
//            draw_legs(gl, glu, 'W', true);
//            draw_arm_left(gl, glu, 'W');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,false,false,false,false,false,false,false);
//        }
//           
//        //Stan is jumping
//        else if(jump && mvt%20+10>20){
//            gl.glTranslatef(0f, 0.35f, 0f);
//            draw_legs(gl, glu, 'J', false);
//            draw_legs(gl, glu, 'J', true);
//            draw_arm_left(gl, glu, 'J');
//            draw_arm_right(gl, glu, 'J');
//            draw_head (gl, glu, true,false,false,false,false,false,false,true,false,false);
//        }
//        else if(jump && mvt%20+10>20){
//            gl.glTranslatef(0f, 0.35f, 0f);
//            draw_legs(gl, glu, 'J', false);
//            draw_legs(gl, glu, 'J', true);
//            draw_arm_left(gl, glu, 'J');
//            draw_arm_right(gl, glu, 'J');
//            draw_head (gl, glu, true,false,false,false,false,false,false,true,false,false);
//        }
//        else if(kick){
//            draw_legs(gl, glu, ' ', false);
//            draw_legs(gl, glu, 'P', true);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,false,true,false,false,false,false,false);
//        }
//        else if(defend){
//            draw_legs(gl, glu, ' ', false);
//            draw_legs(gl, glu, ' ', true);
//            draw_arm_left(gl, glu, 'D');
//            draw_arm_right(gl, glu, 'D');
//            draw_head (gl, glu, false,false,false,true,false,false,false,false,false,false);
//        }
//        else if(greet){
//            draw_legs(gl, glu, ' ', false);
//            draw_legs(gl, glu, ' ', true);
//            draw_arm_left(gl, glu, 'S');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,false,true,false,false,false,false,false);
//        }
//        else if(confuse){
//            draw_legs(gl, glu, ' ', false);
//            draw_legs(gl, glu, ' ', true);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,true,false,false,false,false,false,false);
//        }
//         else if(angry){
//            draw_legs(gl, glu, ' ', false);
//            draw_legs(gl, glu, ' ', true);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,false,true,false,false,false,false,false);
//        }
//          else if(happy){
//            draw_legs(gl, glu, ' ', false);
//            draw_legs(gl, glu, ' ', true);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,false,false,true,false,false,false,false);
//        }
//           else if(serious){
//            draw_legs(gl, glu, 'W', false);
//            draw_legs(gl, glu, 'W', true);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,false,false,false,true,false,false,false);
//        }
//            else if(surprise){
//            draw_legs(gl, glu, ' ', false);
//            draw_legs(gl, glu, ' ', true);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,false,false,false,false,true,false,false);
//        }
//            else if(dislike){
//            draw_legs(gl, glu, 'W', false);
//            draw_legs(gl, glu, 'W', true);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,false,false,false,false,false,true,false);
//            
//        }    else if(sad){
//            draw_legs(gl, glu, ' ', false);
//            draw_legs(gl, glu, ' ', true);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,false,false,false,false,false,false,true);
//        }
//        //stan is normal
//        else{
//            draw_legs(gl, glu, ' ', false);
//            draw_legs(gl, glu, ' ', true);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, ' ');
//            draw_head (gl, glu, false,false,false,false,false,false,false,false,false,false);
//        }   
        
        //Stan is walking
        if(confuse&& mvt%20+10>20){
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, 'W');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,true,false,false,false,false,false,false);
        }
        
        else if(angry&& mvt%20+10>20){
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, 'J', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,false,true,false,false,false,false,false);
        }
        
        else if(happy && mvt%20+10>20){
            draw_legs(gl, glu, 'P', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,false,false,true,false,false,false,false);
        }
        else if(happy && mvt%20+10<=20){
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, 'P', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,false,false,false,false,false,false,false);
        }
        
         else if(serious&& mvt%20+10>20){
            draw_legs(gl, glu, 'D', false);
            draw_legs(gl, glu, 'D', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,false,false,true,false,false,false,false);
        }
         else if(serious&& mvt%20+10<=20){
            draw_legs(gl, glu, 'D', false);
            draw_legs(gl, glu, 'D', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,false,true,true,false,false,false,false);
        }
           
        //Stan is jumping
        else if(surprise && mvt%20+10>20){
            gl.glTranslatef(0f, 0.35f, 0f);
            draw_legs(gl, glu, 'S', false);
            draw_legs(gl, glu, 'S', true);
            draw_arm_left(gl, glu, 'S');
            draw_arm_right(gl, glu, 'S');
            draw_head (gl, glu, true,false,false,false,false,false,false,true,false,false);
        }
        else if(surprise && mvt%20+10>20){
            gl.glTranslatef(0f, 0.35f, 0f);
            draw_legs(gl, glu, 'S', false);
            draw_legs(gl, glu, 'S', true);
            draw_arm_left(gl, glu, 'S');
            draw_arm_right(gl, glu, 'S');
            draw_head (gl, glu, true,false,false,false,false,false,false,true,false,false);
        }
        
        else if(dislike&& mvt%20+10>20){
            gl.glTranslatef(0f, 0.35f, 0f);
            draw_legs(gl, glu, 'S', false);
            draw_legs(gl, glu, 'S', true);
            draw_arm_left(gl, glu, 'S');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,false,true,false,false,false,false,false);
            
        } 
        
        else if(dislike&& mvt%20+10>20){
            gl.glTranslatef(0f, 0.35f, 0f);
            draw_legs(gl, glu, 'S', false);
            draw_legs(gl, glu, 'S', true);
            draw_arm_left(gl, glu, 'S');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,false,false,false,false,false,true,false);
            
        } 
        
        else if(sad&& mvt%20+10>20){
            draw_legs(gl, glu, 'P', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,false,false,false,false,false,false,true);
        }
        
        else if(sad&& mvt%20+10<=20){
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, 'S');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,false,false,false,false,false,false,true);
        }
        
        //stan is normal
        else{
       
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_head (gl, glu, false,false,false,false,false,false,false,false,false,false);
        }
        
        mvt++;
        draw_body (gl, glu);
        draw_hat (gl, glu);
        
        
    }
    
    
    public void draw_body (GL gl, GLU glu){
                     
        //we create stan body
        set_skin_material(gl); 
        gl.glPushMatrix();    
        gl.glTranslatef(0.0f, 0.4f, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, TOP_BODY, BOTTOM_BODY, HEIGHT_BODY, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0.0f, -HEIGHT_BODY, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);
        gl.glPopMatrix();
    }
    
    public void draw_head (GL gl, GLU glu, boolean jump,boolean walk,boolean kick, boolean confuse
            , boolean angry, boolean happy, boolean serious,boolean surprise,
            boolean dislike,boolean sad){
    
     
        //we create eyes (white)
        set_eyes_material(gl);
        
        gl.glPushMatrix();
        gl.glTranslatef(-0.08f, -0.01f, 0.25f);        
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glTranslatef(0.16f, 0.0f, 0.0f);        
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();
        
//        //we create mouth
        gl.glPushMatrix();
        set_black_material(gl);
        //mouth is different when stan is jumping
        if (jump==true){
            set_grey_material(gl);
            gl.glTranslatef(0.0f, -0.3f, 0.31f);        
            glu.gluSphere(q, WIDTH_OPEN_MOUTH, SLICES, STACKS);
        } else if (angry==true) {
            //BOCA
            gl.glPushMatrix();
            gl.glTranslatef(0.1f, -0.2f, 0.4f);   
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glScalef(-0.2f, 0.01f, 0.03f);
            box(gl);
            gl.glPopMatrix();
            //DER
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0.14f, 0.397f);   
            gl.glRotatef(70f, 90f, 0f, 9.5f);
            gl.glScalef(-0.2f, 0.01f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            //IZQ
            gl.glPushMatrix();
            gl.glTranslatef(-0.05f, 0.13f, 0.4f);   
            gl.glRotatef(70f, 90f, 0f, -9.5f);
            gl.glScalef(-0.2f, 0.01f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            
        } else if (confuse==true) {
            //BOCA
            gl.glPushMatrix();
            gl.glTranslatef(-0.01f, -0.2f, 0.4f);   
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glScalef(-0.2f, 0.03f, 0.07f);
            box(gl);
            gl.glPopMatrix();
            //DER
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0.14f, 0.397f);   
            gl.glRotatef(70f, 90f, 0f, 9.5f);
            gl.glScalef(-0.2f, 0.01f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            //IZQ
            gl.glPushMatrix();
            gl.glTranslatef(-0.05f, 0.17f, 0.4f);   
            gl.glRotatef(70f, 90f, 0f, -9.5f);
            gl.glScalef(-0.2f, 0.01f, 0.02f);
            box(gl);
            gl.glPopMatrix();
        
         } else if (happy==true) {
            //BOCA
            gl.glPushMatrix();
            gl.glTranslatef(-0.027f, -0.26f, 0.4f);   
            gl.glRotatef(90f, 2f, 0f, -0.5f);
            gl.glScalef(-0.1f, 0.03f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            gl.glPushMatrix();
            gl.glTranslatef(0.05f, -0.262f, 0.4f);   
            gl.glRotatef(90f, 2f, 0f, 0f);
            gl.glScalef(-0.08f, 0.03f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            gl.glPopMatrix();
             gl.glPushMatrix();
            gl.glTranslatef(0.14f, -0.24f, 0.4f);   
            gl.glRotatef(90f, 2f, 0f, 0.5f);
            gl.glScalef(-0.1f, 0.03f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            
        } else if (serious==true) {
            //BOCA
            gl.glPushMatrix();
            gl.glTranslatef(0.1f, -0.2f, 0.4f);   
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glScalef(-0.2f, 0.01f, 0.05f);
            box(gl);
            gl.glPopMatrix();
            //DER
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0.14f, 0.397f);   
            gl.glRotatef(90f, 1f, 0f,0f);
            gl.glScalef(-0.2f, 0.01f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            //IZQ
            gl.glPushMatrix();
            gl.glTranslatef(-0.05f, 0.14f, 0.4f);   
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glScalef(-0.2f, 0.01f, 0.02f);
            box(gl);
            gl.glPopMatrix();
        
        } else if (surprise==true) {
            //BOCA
            gl.glTranslatef(0.0f, -0.3f, 0.31f);        
            glu.gluSphere(q, WIDTH_OPEN_MOUTH, SLICES, STACKS);
            
            //DER
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0.5f, 0.1f);   
            gl.glRotatef(70f, 90f, 0f, 9.5f);
            gl.glScalef(-0.2f, 0.01f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            
            //IZQ
            gl.glPushMatrix();
            gl.glTranslatef(-0.05f, 0.5f, 0.1f);   
            gl.glRotatef(70f, 90f, 0f, -9.5f);
            gl.glScalef(-0.2f, 0.01f, 0.02f);
            box(gl);
            gl.glPopMatrix();
        }else if (dislike==true) {
            //BOCA
            gl.glPushMatrix();
            gl.glTranslatef(0.2f, -0.2f, 0.38f);   
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glScalef(-0.1f, 0.02f, 0.04f);
            box(gl);
            gl.glPopMatrix();
            //DER
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0.14f, 0.397f);   
            gl.glRotatef(90f, 1f, 0f,0f);
            gl.glScalef(-0.2f, 0.01f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            //IZQ
            gl.glPushMatrix();
            gl.glTranslatef(-0.05f, 0.14f, 0.4f);   
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glScalef(-0.2f, 0.01f, 0.02f);
            box(gl);
            gl.glPopMatrix();
        
        } else if (sad==true) {
            //BOCA
            gl.glPushMatrix();
            gl.glTranslatef(-0.027f, -0.24f, 0.4f);   
            gl.glRotatef(90f, 2f, 0f, 0.5f);
            gl.glScalef(-0.1f, 0.03f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
            gl.glTranslatef(0.05f, -0.229f, 0.4f);   
            gl.glRotatef(90f, 2f, 0f, 0.0f);
            gl.glScalef(-0.08f, 0.03f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
            gl.glTranslatef(0.14f, -0.25f, 0.39f);   
            gl.glRotatef(90f, 2f, 0f, -0.5f);
            gl.glScalef(-0.1f, 0.03f, 0.02f);
            box(gl);
            gl.glPopMatrix();
            
         
        } 
        else{
            gl.glTranslatef(0.1f, -0.2f, 0.37f);   
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glScalef(-0.2f, 0.03f, 0.1f);
            box(gl);
        }
        gl.glPopMatrix();
        
        //we create eyes (black)
        set_grey_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.08f, -0.01f, 0.43f);        
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glTranslatef(0.14f, 0f, 0f);        
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();    
    }
    
    
     public void draw_hat (GL gl, GLU glu){
        
        //we create bottom of bonnet
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.5f, -0.01f);        
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_BONNET, WIDTH_BONNET, HEIGHT_BOTTOM_BONNET, 100, STACKS);  
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0.0f, -HEIGHT_BOTTOM_BONNET+0.005f, 0.02f);        
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f,WIDTH_BONNET, SLICES, STACKS);
        gl.glPopMatrix();
        
        //we create bonnet     
        set_blue_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.5f, 0.0f);
        gl.glRotatef(360f, 1f, 0f, 0f);
        double[] cutplane=new double[]{0.0f,1.0f,0.0f,0.0f};
        gl.glClipPlane(GL.GL_CLIP_PLANE2,cutplane,0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        glu.gluSphere(q, WIDTH_BONNET, 100, 100);    
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();
        
        //we create lunares
        set_eyes_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.08f, 1.3f, 0.27f);        
        glu.gluSphere(q, WIDTH_EYES+0.04f, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-0.55f, 0.8f, 0.65f);        
        glu.gluSphere(q, WIDTH_EYES+0.04f, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, 0.75f, 0.7f);        
        glu.gluSphere(q, WIDTH_EYES+0.04f, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.3f, 0.9f, -0.75f);        
        glu.gluSphere(q, WIDTH_EYES+0.04f, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-0.6f, 1.1f, -0.325f);        
        glu.gluSphere(q, WIDTH_EYES+0.04f, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.6f, 1.15f, -0.03f);        
        glu.gluSphere(q, WIDTH_EYES+0.04f, SLICES, STACKS);
        gl.glPopMatrix(); 
     }
     
      
     public void draw_legs(GL gl, GLU glu, char c, boolean left){
        gl.glPushMatrix();
        
        //we orientate axes if stan is jumping or is walking
        if (c=='W'){
            gl.glTranslatef(0f, -0.1f, -0.2f);
            gl.glRotatef(30, -100f, 0f, 0f);            
        }
         if (c=='P'){
            gl.glTranslatef(0f, -0.1f, -0.2f);
            gl.glRotatef(50, -100f, 0f, 0f);            
        }
        
        if (c=='J'){
            gl.glTranslatef(0f, -0.05f, -0.1f);
            if (left)
                gl.glRotatef(30, -100f, -100f, 0f); 
            else
                gl.glRotatef(30, -100f, 100f, 0f);                      
        }
         
                     
        //we create legs
        set_brown_material(gl);
        gl.glPushMatrix();
        if (left)
            gl.glTranslatef(-0.19f, -0.45f, 0f);        
        else
            gl.glTranslatef(0.19f, -0.45f, 0f);     
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0f, -HEIGHT_LEGS, 0f);        
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glPopMatrix();
        
        //we create shoes
        set_black_material(gl);
        gl.glPushMatrix();
        if (left){
            gl.glTranslatef(-0.34f, -0.7f, -0.15f);
            gl.glScalef(WIDTH_SHOES, HEIGHT_SHOES, 0.25f);
        }
        else{
            gl.glTranslatef(0.34f, -0.7f, -0.15f);
            gl.glScalef(-WIDTH_SHOES, HEIGHT_SHOES, 0.25f);
        }
        box(gl);
        gl.glPopMatrix();             
        gl.glPushMatrix();
        if (left)   
            gl.glTranslatef(-0.2f, -0.65f, 0.12f);  
        else
            gl.glTranslatef(0.2f, -0.65f, 0.12f);
         gl.glRotatef(90f, 1f, 0f, 0f);
         glu.gluDisk(q, 0f, 0.14, SLICES, STACKS);
         glu.gluCylinder(q, WIDTH_SHOES / 2, WIDTH_SHOES / 2, HEIGHT_SHOES, SLICES, STACKS);
         gl.glRotatef(90f, -1f, 0f, 0f);
         gl.glTranslatef(0f, -HEIGHT_SHOES, 0f);
         gl.glRotatef(90f, 1f, 0f, 0f);
         glu.gluDisk(q, 0f, WIDTH_SHOES / 2, SLICES, STACKS);
         gl.glPopMatrix();
        
        gl.glPopMatrix();
     }
     
     
     public void draw_arm_left (GL gl, GLU glu, char c){
        set_rose_material(gl); 
        gl.glPushMatrix();
        //we orientate axes if stan is walking or is jumping
        if (c=='J'){
            gl.glTranslatef(-0.47f, 0.15f, -0.01f);  
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);   
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c=='W'){  
            gl.glTranslatef(-0.45f, -0.38f, 0.1f);  
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);   
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c=='S'){  
            
            gl.glTranslatef(-0.47f, 0.15f, -0.01f);  
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);   
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
         if (c=='D'){  
            
            gl.glTranslatef(-0.5f, -0.10f, 0.13f);  
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);   
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c==' '){
            gl.glTranslatef(-0.45f, -0.42f, 0f);  
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.055f, 0.015f, 0.05f);   
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }    
        
        gl.glPopMatrix();
        
        
        //we create left arm
        set_brown_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.37f, -0.125f, 0f);        
        gl.glRotatef(90f, 1f, -0.20f, 0f);
        if (c=='J'){
            gl.glRotatef(150, 0f, -100f, 0f);
        }if (c=='S') {
            gl.glRotatef(150, 0f, -100f, 0f);
            
        }if (c=='D') {
            gl.glTranslatef(-0.1f, -0.125f, 0f); 
            gl.glRotatef(-90, 90f, 0f, 0f);
            
        }
        if (c=='W'){
        gl.glRotatef(20, -1f, 0f, 0f);
        }
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS); 
        gl.glRotatef(90f, -1f, 0.20f, 0f);    
        gl.glTranslatef(0f, -HEIGHT_ARMS, 0f);     
        gl.glRotatef(90f, 1f, -0.20f, 0f);
         
        if (c!=' '){
            glu.gluDisk(q, 0f, WIDTH_ARMS-0.03, SLICES, STACKS);
     }
     gl.glPopMatrix();
     }
     public void draw_arm_right (GL gl, GLU glu, char c){
         
        set_rose_material(gl); 
        gl.glPushMatrix();
        
        //we orientate axes if stan is walking or is jumping
        if (c=='J'){
            gl.glTranslatef(0.47f, 0.15f, -0.01f);  
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.05f, 0.015f, 0.05f);   
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c=='W'){  
            gl.glTranslatef(0.45f, -0.38f, 0.1f);  
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.05f, 0.015f, 0.05f);   
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c=='D'){
            gl.glTranslatef(0.5f, -0.2f, 0.13f);  
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.05f, 0.015f, 0.05f);   
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c==' '){
            gl.glTranslatef(0.45f, -0.42f, 0f);  
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.055f, 0.015f, 0.05f);   
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }       
     
        gl.glPopMatrix();
        //we create right arm
        set_brown_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.37f, -0.125f, 0f);        
        gl.glRotatef(90f, 1f, 0.20f, 0f);
        if (c=='J'){
            gl.glRotatef(150, 0f, 100f, 0f);
            
        }if (c=='D'){
            gl.glTranslatef(0.1f, -0.125f, 0.1f);
            gl.glRotatef(-90, 90f, 0, 0f);
        
        }if (c=='W'){
        gl.glRotatef(20, -1f, 0f, 0f);
        }
        
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS); 
        gl.glRotatef(90f, -1f, -0.20f, 0f);    
        gl.glTranslatef(0f, -HEIGHT_ARMS, 0f);     
        gl.glRotatef(90f, 1f, 0.20f, 0f);
        
        if (c==' '){
            glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
            }
        gl.glPopMatrix();
    }
     
     public void draw_scarf (GL gl, GLU glu){
       
//        //we create scarf
//        set_red_material(gl);
//        gl.glPushMatrix();
//        gl.glTranslatef(0.0f, 0f, 0.0f);
//        gl.glRotatef(93f, 1f, 0f, 0f);
//        draw_torus(gl, 0.32f, 0.092f, SLICES, STACKS);
//        gl.glPopMatrix();
//        
     }
    
     
     public void draw_torus (GL gl, float R, float r, int N, int n){
        
        int maxn= 1000;
        n=Math.min(n,maxn-1);
        N=Math.min(N,maxn-1);
        float rr=1.5f*r;
        double dv=2*Math.PI/n;
        double dw=2*Math.PI/N;
        double v=0.0f;
        double w=0.0f;
        while(w<2*Math.PI+dw)
        {
            v=0.0f;
            gl.glBegin(GL.GL_TRIANGLE_STRIP);
            while(v<2*Math.PI+dv)
            {
                gl.glNormal3d(
                        (R+rr*Math.cos(v))*Math.cos(w)-(R+r*Math.cos(v))*Math.cos(w),
                        (R+rr*Math.cos(v))*Math.sin(w)-(R+r*Math.cos(v))*Math.sin(w),
                        (rr*Math.sin(v)-r*Math.sin(v)));
                gl.glVertex3d((R+r*Math.cos(v))*Math.cos(w),
                           (R+r*Math.cos(v))*Math.sin(w),
                            r*Math.sin(v));
                gl.glNormal3d(
                        (R+rr*Math.cos(v+dv))*Math.cos(w+dw)-(R+r*Math.cos(v+dv))*Math.cos(w+dw),
                        (R+rr*Math.cos(v+dv))*Math.sin(w+dw)-(R+r*Math.cos(v+dv))*Math.sin(w+dw),
                        rr*Math.sin(v+dv)-r*Math.sin(v+dv));
                gl.glVertex3d((R+r*Math.cos(v+dv))*Math.cos(w+dw),
                           (R+r*Math.cos(v+dv))*Math.sin(w+dw),
                            r*Math.sin(v+dv));
                v+=dv;
            }
            gl.glEnd();
            w+=dw;
        }
    }
     
     
    public void set_skin_material (GL gl){    
        float mat_ambient[]={0.6f,0.5f,0.8f,1.0f};
        float mat_diffuse[]={0.0f,0.0f,0.0f,0.0f};
        float shine=9.84615f;
                
        
//        float[] mat_ambient ={0.5f,0.0f, 0.5f, 0.0f};
//        float[] mat_diffuse ={1.0f,0.5f,0.5f,0.0f};
//        float shine = 128f;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    
    
    public void set_shirt_material (GL gl){    
   
        float mat_ambient[]={ 0.5f, 0.45f, 0.3f, 1.0f };
        float[] mat_diffuse ={ 0.8f,0.8f,0.8f,1.0f};
        float mat_specular[]={ 0.4f, 0.3f, 0.2f, 1.0f };
        float shine=128f;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    
    
    public void set_rose_material (GL gl){
        
        float[] mat_ambient ={ 0.25f,0.20725f,0.20725f,0.922f };
        float[] mat_diffuse ={ 1.5f,0.829f,0.829f,0.922f};
        float[] mat_specular ={0.296648f,0.296648f,0.296648f,0.922f };
        float shine =11.264f ;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    
    
    public void set_eyes_material (GL gl){
        
        float mat_ambient[]={1.0f,1.0f,1.0f,1.0f};
        float mat_diffuse[]={1.0f,1.0f,1.0f,1.0f};
        float mat_specular[]={0.8f,0.8f,0.8f,1.0f};
        float shine=51.2f;    
                
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    
    
    public void set_blue_material (GL gl){
        
        float mat_ambient[]={0.2f,0.2f,0.6f,1.0f};
        float mat_diffuse[]={1.0f,1.0f,1.0f,1.0f};
        float mat_specular[]={0.8f,0.8f,0.8f,1.0f};
        float shine=125.2f;    
                
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    
    
    public void set_grey_material (GL gl){
        
        float mat_ambient[]={0.07f,0.07f,0.07f,0.0f};
        float mat_diffuse[]={1.0f,1.0f,1.0f,1.0f};
        float mat_specular[]={0.8f,0.8f,0.8f,1.0f};
        float shine=125.2f;    
                
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
        
    
    public void set_black_material (GL gl){
        
        float mat_ambient[]={0.0f,0.0f,0.0f,1.0f};
        float mat_diffuse[]={0.0f,0.0f,0.0f,1.0f};
        float mat_specular[]={0.0f,0.0f,0.0f,1.0f};
        float shine=125.2f;    
                
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    
         
    public void set_purple_material (GL gl){
        
        float mat_ambient[]={0.54583f,0.0f,0.9762f,0.0f};
        float mat_diffuse[]={0.0f,0.0f,0.0f,1.0f};
        float mat_specular[]={0.333333f,0.333333f,0.521569f,1.0f};
        float shine=9.84615f;   

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
       public void set_brown_material (GL gl){
        
        float mat_ambient[]={0.6f,0.5f,0.6f,0.3f};
        float mat_diffuse[]={0.0f,0.0f,0.0f,0.0f};
        float mat_specular[]={0.774597f,0.458561f,0.200621f,1.0f};
        float shine=76.8f;    
                
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    public void box (GL gl){
        gl.glBegin(GL.GL_POLYGON);/* f1: front */
            gl.glNormal3f(-1.0f,0.0f,0.0f);
            gl.glVertex3f(0.0f,0.0f,0.0f);
            gl.glVertex3f(0.0f,0.0f,1.0f);
            gl.glVertex3f(1.0f,0.0f,1.0f);
            gl.glVertex3f(1.0f,0.0f,0.0f);
          gl.glEnd();
          gl.glBegin(GL.GL_POLYGON);/* f2: bottom */
            gl.glNormal3f(0.0f,0.0f,-1.0f);
            gl.glVertex3f(0.0f,0.0f,0.0f);
            gl.glVertex3f(1.0f,0.0f,0.0f);
            gl.glVertex3f(1.0f,1.0f,0.0f);
            gl.glVertex3f(0.0f,1.0f,0.0f);
          gl.glEnd();
          gl.glBegin(GL.GL_POLYGON);/* f3:back */
            gl.glNormal3f(1.0f,0.0f,0.0f);
            gl.glVertex3f(1.0f,1.0f,0.0f);
            gl.glVertex3f(1.0f,1.0f,1.0f);
            gl.glVertex3f(0.0f,1.0f,1.0f);
            gl.glVertex3f(0.0f,1.0f,0.0f);
          gl.glEnd();
          gl.glBegin(GL.GL_POLYGON);/* f4: top */
            gl.glNormal3f(0.0f,0.0f,1.0f);
            gl.glVertex3f(1.0f,1.0f,1.0f);
            gl.glVertex3f(1.0f,0.0f,1.0f);
            gl.glVertex3f(0.0f,0.0f,1.0f);
            gl.glVertex3f(0.0f,1.0f,1.0f);
          gl.glEnd();
          gl.glBegin(GL.GL_POLYGON);/* f5: left */
            gl.glNormal3f(0.0f,1.0f,0.0f);
            gl.glVertex3f(0.0f,0.0f,0.0f);
            gl.glVertex3f(0.0f,1.0f,0.0f);
            gl.glVertex3f(0.0f,1.0f,1.0f);
            gl.glVertex3f(0.0f,0.0f,1.0f);
          gl.glEnd();
          gl.glBegin(GL.GL_POLYGON);/* f6: right */
            gl.glNormal3f(0.0f,-1.0f,0.0f);
            gl.glVertex3f(1.0f,0.0f,0.0f);
            gl.glVertex3f(1.0f,0.0f,1.0f);
            gl.glVertex3f(1.0f,1.0f,1.0f);
            gl.glVertex3f(1.0f,1.0f,0.0f);
          gl.glEnd();
          
    }
    
     public void fondo(GL gl, GLU glu, Texture t){
        int m = t.getTextureObject();
        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glBindTexture(GL.GL_TEXTURE_2D,m);
        
         
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2d(0.0f, 1.0f);
        gl.glVertex3d(-6.0f,-6.0f ,-6.0f);
        
        gl.glTexCoord2d(1.0f, 1.0f);
        gl.glVertex3d(6.0f,-6.0f ,-6.0f);
        
        gl.glTexCoord2d(1.0f, 0.0f);
        gl.glVertex3d(6.0f,6.0f,-6.0f);
        
        gl.glTexCoord2d(0.0f, 0.0f);
        gl.glVertex3d(-6.0f,6.0f,-6.0f);
        
        gl.glEnd();
        gl.glFlush();
        gl.glDisable(GL.GL_TEXTURE_2D);
    }
    public void FondoMenu(GL gl, GLU glu, Texture t){
        
        int m = t.getTextureObject();
        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glBindTexture(GL.GL_TEXTURE_2D,m);
        
         
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2d(0.0f, 1.0f);
        gl.glVertex3d(-6.0f,-6.0f ,-6.0f);
        
    }
    
}