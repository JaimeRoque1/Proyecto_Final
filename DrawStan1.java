package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class DrawStan1 {

    //precision and global variables
    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private GLUquadric q = null;
    private static int mvt = 0;
    Texture tAtras, tFrente, tDerecha, tIzquierda, tAbajo, tArriba;

    //heigth and widht of each components
    private static final float HEIGHT_BODY = 0.80f;
    private static final float TOP_BODY = 0.20f;
    private static final float BOTTOM_BODY = 0.40f;
    private static final float HEIGHT_LEGS = 0.5f;
    private static final float WIDTH_LEGS = 0.05f;
    private static final float HEIGHT_ARMS = 0.3f;
    private static final float WIDTH_ARMS = 0.2f;
    private static final float WIDTH_HEAD = 0.5f;
    private static final float WIDTH_HANDS = 0.1f;
    private static final float WIDTH_FINGERS = 0.0525f;
    private static final float WIDTH_OPEN_MOUTH = 0.1f;
    private static final float WIDTH_BUTTONS = 0.0400f;
    private static final float WIDTH_PUPILS = 0.05f;
    private static final float HEIGHT_BASTON = 1f;
    private static final float WIDTH_BASTON = 0.05f;

    //position of each component int the window
    public DrawStan1() {
    }

    public void draw_stan1(GL gl, boolean walk, boolean jump, boolean angry, boolean ready,
            boolean cry, boolean meditation, boolean ofrecer) {

        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);

        //camina
        if (walk && mvt % 20 + 10 > 20) {
            draw_legs(gl, glu, 'W', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, 'W');
            draw_baston(gl, glu, ' ');
            draw_head(gl, glu, false, false, false, false);
            draw_body(gl, glu);
            draw_eyes(gl, glu, false);

        } else if (walk && mvt % 20 + 10 <= 20) {
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, 'W', true);
            draw_arm_left(gl, glu, 'W');
            draw_arm_right(gl, glu, ' ');
            draw_head(gl, glu, false, false, false, false);
            draw_baston(gl, glu, ' ');
            draw_body(gl, glu);
            draw_eyes(gl, glu, false);
        } //Salta       
        else if (jump && mvt % 20 + 10 > 20) {
            gl.glTranslatef(0f, 0.35f, 0f);
            draw_legs(gl, glu, 'J', false);
            draw_legs(gl, glu, 'J', true);
            draw_arm_left(gl, glu, 'J');
            draw_arm_right(gl, glu, 'J');
            draw_head(gl, glu, true, false, false, false);
            draw_baston(gl, glu, ' ');
            draw_body(gl, glu);
            draw_eyes(gl, glu, false);
        } //Longe is angry
        else if (angry) {
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, 'W', true);
            draw_arm_left(gl, glu, 'J');
            draw_arm_right(gl, glu, 'J');
            draw_head(gl, glu, false, true, false, false);
            draw_baston(gl, glu, ' ');
            draw_body(gl, glu);
            draw_eyes(gl, glu, false);
        } //Longe is ready
        else if (ready) {
            draw_body(gl, glu);
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, 'R');
            draw_arm_right(gl, glu, 'R');
            draw_head(gl, glu, false, true, false, false);
            draw_baston(gl, glu, 'R');
            draw_eyes(gl, glu, false);

        } else if (cry) {
            draw_body(gl, glu);
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_head(gl, glu, false, false, true, false);
            draw_baston(gl, glu, ' ');
            draw_eyes(gl, glu, false);

        } else if (meditation) {
            draw_body(gl, glu);
            draw_arm_left(gl, glu, 'M');
            draw_arm_right(gl, glu, 'M');
            draw_head(gl, glu, false, false, false, true);
            draw_baston(gl, glu, ' ');
            draw_eyes(gl, glu, true);

        } else if (ofrecer) {
            draw_body(gl, glu);
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, 'O');
            draw_arm_right(gl, glu, 'R');
            draw_head(gl, glu, false, false, false, false);
            draw_baston(gl, glu, 'O');
            draw_eyes(gl, glu, false);
            
        } else {
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_head(gl, glu, false, false, false, false);
            draw_body(gl, glu);
            draw_baston(gl, glu, ' ');
            draw_eyes(gl, glu, false);
        }

        mvt++;
        draw_body(gl, glu);

    }

    public void draw_body(GL gl, GLU glu) {

        //we create stan body
        set_grey_material(gl);
        gl.glPushMatrix();
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, TOP_BODY, BOTTOM_BODY, HEIGHT_BODY, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0.0f, -HEIGHT_BODY, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);
        gl.glPopMatrix();

    }

    public void draw_eyes(GL gl, GLU glu, boolean meditation) {

        if (meditation == true) {
            //ceja izquierda
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.15f, 0.35f, 0.38f);
            gl.glScalef(0.1f, 0.01f, 0.1f);
            box(gl);

            gl.glPopMatrix();

            //ceja derecha
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.05f, 0.35f, 0.38f);
            gl.glScalef(0.1f, 0.01f, 0.1f);
            box(gl);

            gl.glPopMatrix();
        } else {
            //we create eyes (black)
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.07f, 0.35f, 0.468f);
            glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
            gl.glTranslatef(0.14f, 0f, 0f);
            glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
            gl.glPopMatrix();
        }
    }

    public void draw_head(GL gl, GLU glu, boolean jump, boolean angry, boolean sad, boolean meditation) {

        //we create head
        set_skin_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.5f, 0f);
        glu.gluSphere(q, WIDTH_HEAD, SLICES, STACKS);
        gl.glPopMatrix();

        

        //we create mouth
        gl.glPushMatrix();
        set_black_material(gl);
        //mouth is different when stan is jumping
        if (jump == true) {
            set_grey_material(gl);
            gl.glTranslatef(0.0f, 0.19f, 0.275f);
            glu.gluSphere(q, WIDTH_OPEN_MOUTH, SLICES, STACKS);
        }

        if (angry == true) {
            //ceja izquierda
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.45f, 0.420f);
            gl.glRotatef(45f, 0.0f, 0.0f, 1f);
            gl.glScalef(0.2f, 0.03f, 0.1f);
            box(gl);

            gl.glPopMatrix();

            //ceja derecha
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.45f, 0.420f);
            gl.glRotatef(135f, 0.0f, 0.0f, 1f);
            gl.glScalef(0.2f, 0.03f, 0.1f);
            box(gl);

            gl.glPopMatrix();
        }

        if (sad == true) {
            //ceja izquierda
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.6f, 0.420f);
            gl.glRotatef(-45f, 0.0f, 0.0f, 1f);
            gl.glScalef(0.2f, 0.03f, 0.1f);
            box(gl);

            gl.glPopMatrix();

            //ceja derecha
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.6f, 0.420f);
            gl.glRotatef(-135f, 0.0f, 0.0f, 1f);
            gl.glScalef(0.2f, 0.03f, 0.1f);
            box(gl);

            gl.glPopMatrix();
        }

        gl.glTranslatef(0.1f, 0.19f, 0.257f);
        gl.glRotatef(45f, 1f, 0f, 0f);
        gl.glScalef(-0.2f, 0.03f, 0.1f);
        box(gl);

        gl.glPopMatrix();

    }

    public void draw_baston(GL gl, GLU glu, char c) {
        set_brown_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.37f, 0.125f, -0.35f);
        gl.glRotatef(90f, 1f, -0.5f, 0f);

        if (c == 'J') {
            gl.glRotatef(150, 0f, 100f, 0f);
        }
        if (c == 'W') {
            gl.glRotatef(20, -1f, 0f, 0f);
        }

        if (c == 'R') {
            gl.glTranslatef(0.5f, 0.7f, -0.5f);
        }

        if (c == 'O') {
            gl.glTranslatef(0f, 1.1f, -0.5f);
            //gl.glRotatef(140, 0f, 0f, 1f);
        }

        glu.gluCylinder(q, WIDTH_BASTON, WIDTH_BASTON, HEIGHT_BASTON, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_BASTON, SLICES, STACKS);
        gl.glTranslatef(0f, -HEIGHT_BASTON, 0f);

        if (c == ' ') {

        }
        gl.glPopMatrix();
    }

   
    public void draw_legs(GL gl, GLU glu, char c, boolean left) {
        gl.glPushMatrix();

        //we orientate axes if stan is jumping or is walking
        if (c == 'W') {
            gl.glTranslatef(0f, -0.1f, -0.2f);
            gl.glRotatef(30, -100f, 0f, 0f);
        }

        if (c == 'J') {
            gl.glTranslatef(0f, -0.05f, -0.1f);
            if (left) {
                gl.glRotatef(30, -100f, -100f, 0f);
            } else {
                gl.glRotatef(30, -100f, 100f, 0f);
            }
        }

        //we create legs
        set_skin_material(gl);
        gl.glPushMatrix();
        if (left) {
            gl.glTranslatef(-0.19f, -0.45f, 0f);
        } else {
            gl.glTranslatef(0.19f, -0.45f, 0f);
        }
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0f, -HEIGHT_LEGS, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        //glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glPopMatrix();

    }

    public void draw_arm_left(GL gl, GLU glu, char c) {
        set_skin_material(gl);
        gl.glPushMatrix();
        //we orientate axes if stan is walking or is jumping
        if (c == 'J') {
            gl.glTranslatef(-0.47f, 0.15f, -0.01f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c == 'W') {
            gl.glTranslatef(-0.45f, -0.38f, 0.1f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }

        if (c == 'R') {
            gl.glTranslatef(-0.35f, -0.45f, -0.2f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }

        if (c == 'O') {
            gl.glTranslatef(-0.45f, -0.15f, 0.4f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }

        if (c == 'M') {
            gl.glTranslatef(-0.15f, -0.20f, 0.3f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }

        if (c == ' ') {
            gl.glTranslatef(-0.45f, -0.42f, 0f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.055f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }

        gl.glPopMatrix();

        //we create left arm
        set_shirt_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.37f, -0.125f, 0f);
        gl.glRotatef(90f, 1f, -0.20f, 0f);

        if (c == 'J') {
            gl.glRotatef(150, 0f, -100f, 0f);
        }

        if (c == 'W') {
            gl.glRotatef(20, -1f, 0f, 0f);
        }

        if (c == 'R') {
            gl.glRotatef(45f, 1f, 0f, 1f);
        }

        if (c == 'O') {
            gl.glRotatef(180f, 0f, 1f, 1f);
        }

        if (c == 'M') {
            gl.glRotatef(140f, 0.5f, 1f, 1f);
        }

        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0.20f, 0f);
        gl.glTranslatef(0f, -HEIGHT_ARMS, 0f);
        gl.glRotatef(90f, 1f, -0.20f, 0f);
        if (c != 'J') {
            glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        }
        gl.glPopMatrix();
    }

    public void draw_arm_right(GL gl, GLU glu, char c) {

        set_skin_material(gl);
        gl.glPushMatrix();

        //we orientate axes if stan is walking or is jumping
        if (c == 'J') {
            gl.glTranslatef(0.47f, 0.15f, -0.01f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c == 'W') {
            gl.glTranslatef(0.45f, -0.38f, 0.1f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }

        if (c == 'R') {
            gl.glTranslatef(0.45f, -0.15f, 0.4f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }

        if (c == 'M') {
            gl.glTranslatef(0.30f, -0.15f, 0.4f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }

        if (c == ' ') {
            gl.glTranslatef(0.45f, -0.42f, 0f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.055f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }

        gl.glPopMatrix();
        //we create right arm
        set_shirt_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.37f, -0.125f, 0f);
        gl.glRotatef(90f, 1f, 0.20f, 0f);
        if (c == 'J') {
            gl.glRotatef(150, 1f, 100f, 0f);
        }
        if (c == 'W') {
            gl.glRotatef(20, -1f, 0f, 0f);
        }

        if (c == 'R') {
            gl.glRotatef(180f, 0f, 1f, 1f);
        }

        if (c == 'M') {
            gl.glRotatef(130f, -1f, 0.5f, 1f);
        }

        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, -0.20f, 0f);
        gl.glTranslatef(0f, -HEIGHT_ARMS, 0f);
        gl.glRotatef(90f, 1f, 0.20f, 0f);
        if (c == ' ') {
            glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        }
        gl.glPopMatrix();
    }

    public void draw_torus(GL gl, float R, float r, int N, int n) {

        int maxn = 1000;
        n = Math.min(n, maxn - 1);
        N = Math.min(N, maxn - 1);
        float rr = 1.5f * r;
        double dv = 2 * Math.PI / n;
        double dw = 2 * Math.PI / N;
        double v = 0.0f;
        double w = 0.0f;
        while (w < 2 * Math.PI + dw) {
            v = 0.0f;
            gl.glBegin(GL.GL_TRIANGLE_STRIP);
            while (v < 2 * Math.PI + dv) {
                gl.glNormal3d(
                        (R + rr * Math.cos(v)) * Math.cos(w) - (R + r * Math.cos(v)) * Math.cos(w),
                        (R + rr * Math.cos(v)) * Math.sin(w) - (R + r * Math.cos(v)) * Math.sin(w),
                        (rr * Math.sin(v) - r * Math.sin(v)));
                gl.glVertex3d((R + r * Math.cos(v)) * Math.cos(w),
                        (R + r * Math.cos(v)) * Math.sin(w),
                        r * Math.sin(v));
                gl.glNormal3d(
                        (R + rr * Math.cos(v + dv)) * Math.cos(w + dw) - (R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + rr * Math.cos(v + dv)) * Math.sin(w + dw) - (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
                        rr * Math.sin(v + dv) - r * Math.sin(v + dv));
                gl.glVertex3d((R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
                        r * Math.sin(v + dv));
                v += dv;
            }
            gl.glEnd();
            w += dw;
        }
    }

    public void set_skin_material(GL gl) {
        float[] mat_ambient ={0.9550f,0.5011f, 0.1803f, 0.5f};
        float[] mat_diffuse ={0.9550f,0.5011f,0.1803f,0.5f};
        float[] mat_specular = {0.9550f, 0.5011f, 0.1803f, 0.5f};
        float shine = 40f;
        

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        

    }

    public void set_shirt_material(GL gl) {

        float mat_ambient[] = {0.3333f, 0.1568f, 0.0f, 0.0f};
        float[] mat_diffuse = {0.3333f, 0.1568f, 0.0f, 0.0f};
        float mat_specular[] = {0.3333f, 0.1568f, 0.0f, 0.0f};
        float shine = 60f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_red_material(GL gl) {

        float[] mat_ambient = {0f, 0f, 0f, 1f};
        float[] mat_diffuse = {0.55f, 0.55f, 0.55f, 1.0f};
        float[] mat_specular = {0.70f, 0.70f, 0.70f, 1.0f};
        float shine = 32.0f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_eyes_material(GL gl) {

        float mat_ambient[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 51.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_blue_material(GL gl) {

        float mat_ambient[] = {0f, 0f, 0f, 1.0f};
        float mat_diffuse[] = {0.5f, 0.5f, 0f, 1.0f};
        float mat_specular[] = {0.60f, 0.60f, 0.50f, 1.0f};
        float shine = 32f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_grey_material(GL gl) {

       float mat_ambient[] = {0.3333f, 0.1568f, 0.0f, 0.0f};
        float[] mat_diffuse = {0.3333f, 0.1568f, 0.0f, 0.0f};
        float mat_specular[] = {0.3333f, 0.1568f, 0.0f, 0.0f};
        float shine = 60f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_black_material(GL gl) {

        float mat_ambient[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float mat_diffuse[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float mat_specular[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_chaleco_material(GL gl) {

        float mat_ambient[] = {0.3333f, 0.1568f, 0.0f, 0.0f};
        float[] mat_diffuse = {0.3333f, 0.1568f, 0.0f, 0.0f};
        float mat_specular[] = {0.3333f, 0.1568f, 0.0f, 0.0f};
        float shine = 60f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_brown_material(GL gl) {
        float mat_ambient[] = {0.6117f, 0.0f, 0.8627f, 0.8f};
        float[] mat_diffuse = {0.6117f, 0.0f, 0.8627f, 0.8f};
        float mat_specular[] = {0.6117f, 0.0f, 0.8627f, 0.8f};
        float shine = 3f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void box(GL gl) {
        gl.glBegin(GL.GL_POLYGON);/* f1: front */
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: bottom */
        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f3:back */
        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f4: top */
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: left */
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: right */
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();

    }

    public void ponerFondo(GL gl, GLU glu, boolean fon2, boolean fon3, boolean fon4, boolean fon5) throws IOException {

        float mat_ambient[] = {0.9f, 0.9f, 0.9f, 1.0f};
        float mat_diffuse[] = {0.3f, 0.3f, 0.3f, 1.0f};
        float mat_specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float light_position[] = {0.0f, 1.5f, 1.0f, 1.0f};
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

        
        
        File fondo2_frente = new File("src/Imagenes/Fondo3/Frente.jpg");
        File fondo2_atras = new File("src/Imagenes/Fondo3/Atras.jpg");
        File fondo2_lados = new File("src/Imagenes/Fondo3/Lados.jpg");
        
        File fondo3 = new File("src/Imagenes/Fondo4/estrella.jpg");
        
        File fondo4_templo = new File("src/Imagenes/Fondo2/Fondo.jpg");
        File fondo4_cielo = new File("src/Imagenes/Fondo2/Cielo.jpg");
        File fondo4_suelo = new File("src/Imagenes/Fondo2/Suelo.jpg");
        File fondo4_frente = new File("src/Imagenes/Fondo2/Frente.jpg");
        File fondo4_lados = new File("src/Imagenes/Fondo2/lados.jpg");
        
        File fondo5 = new File("src/Imagenes/Fondo5/Dojo.jpg");
        
        
        //Caminar
        if(fon2){
            tAtras = TextureIO.newTexture(fondo2_atras, true);
            gl.glPushMatrix();
            fondo(gl, glu, tAtras);
            gl.glPopMatrix();
            gl.glFlush();
            
            tFrente = TextureIO.newTexture(fondo2_frente, true);
            gl.glPushMatrix();
            gl.glRotatef(180f, 0.0f, 1f, 0.0f);
            fondo(gl, glu, tFrente);
            gl.glPopMatrix();
            gl.glFlush();
            
            tDerecha = TextureIO.newTexture(fondo2_lados, true);
            gl.glPushMatrix();
            gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
            fondo(gl, glu, tDerecha);
            gl.glPopMatrix();
            gl.glFlush();
            
            tIzquierda = TextureIO.newTexture(fondo2_lados, true);
            gl.glPushMatrix();
            gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
            fondo(gl, glu, tIzquierda);
            gl.glPopMatrix();
            gl.glFlush();
        }
        
        if(fon3){
            tAtras = TextureIO.newTexture(fondo3, true);
            gl.glPushMatrix();
            fondo(gl, glu, tAtras);
            gl.glPopMatrix();
            gl.glFlush();
           
            tFrente = TextureIO.newTexture(fondo3, true);
            gl.glPushMatrix();
            gl.glRotatef(180f, 0.0f, 1f, 0.0f);
            fondo(gl, glu, tFrente);
            gl.glPopMatrix();
            gl.glFlush();
            
            tDerecha = TextureIO.newTexture(fondo3, true);
            gl.glPushMatrix();
            gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
            fondo(gl, glu, tDerecha);
            gl.glPopMatrix();
            gl.glFlush();
            
            tIzquierda = TextureIO.newTexture(fondo3, true);
            gl.glPushMatrix();
            gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
            fondo(gl, glu, tIzquierda);
            gl.glPopMatrix();
            gl.glFlush();
        }
     
        //Meditar
        if (fon4) {
            tAtras = TextureIO.newTexture(fondo4_templo, true);
            gl.glPushMatrix();
            fondo(gl, glu, tAtras);
            gl.glPopMatrix();
            gl.glFlush();

            tArriba = TextureIO.newTexture(fondo4_cielo, true);
            gl.glPushMatrix();
            fondo(gl, glu, tArriba);
            gl.glPopMatrix();
            gl.glFlush();
            
            tAbajo = TextureIO.newTexture(fondo4_suelo, true);
            gl.glPushMatrix();
            gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
            fondo(gl, glu, tAbajo);
            gl.glPopMatrix();
            gl.glFlush();    
            
            tFrente = TextureIO.newTexture(fondo4_frente, true);
            gl.glPushMatrix();
            gl.glRotatef(180f, 0.0f, 1f, 0.0f);
            fondo(gl, glu, tFrente);
            gl.glPopMatrix();
            gl.glFlush();
            
            tDerecha = TextureIO.newTexture(fondo4_lados, true);
            gl.glPushMatrix();
            gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
            fondo(gl, glu, tDerecha);
            gl.glPopMatrix();
            gl.glFlush();
            
            tIzquierda = TextureIO.newTexture(fondo4_lados, true);
            gl.glPushMatrix();
            gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
            fondo(gl, glu, tIzquierda);
            gl.glPopMatrix();
            gl.glFlush();
        }
        
        //Pelea
        if(fon5){
            tAtras = TextureIO.newTexture(fondo5, true);
            gl.glPushMatrix();
            fondo(gl, glu, tAtras);
            gl.glPopMatrix();
            gl.glFlush();      
            
            tFrente = TextureIO.newTexture(fondo5, true);
            gl.glPushMatrix();
            gl.glRotatef(180f, 0.0f, 1f, 0.0f);
            fondo(gl, glu, tFrente);
            gl.glPopMatrix();
            gl.glFlush();
            
            tIzquierda = TextureIO.newTexture(fondo5, true);
            gl.glPushMatrix();
            gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
            fondo(gl, glu, tIzquierda);
            gl.glPopMatrix();
            gl.glFlush();
            
            tDerecha = TextureIO.newTexture(fondo5, true);
            gl.glPushMatrix();
            gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
            fondo(gl, glu, tDerecha);
            gl.glPopMatrix();
            gl.glFlush();
        }

    }

    public void fondo(GL gl, GLU glu, Texture t) {
        int m = t.getTextureObject();
        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glBindTexture(GL.GL_TEXTURE_2D, m);
        gl.glBegin(GL.GL_QUADS);

        gl.glTexCoord2d(0.0f, 1.0f);
        gl.glVertex3d(-6.0f, -6.0f, -6.0f);

        gl.glTexCoord2d(1.0f, 1.0f);
        gl.glVertex3d(6.0f, -6.0f, -6.0f);

        gl.glTexCoord2d(1.0f, 0.0f);
        gl.glVertex3d(6.0f, 6.0f, -6.0f);

        gl.glTexCoord2d(0.0f, 0.0f);
        gl.glVertex3d(-6.0f, 6.0f, -6.0f);

        gl.glEnd();
    }

}
