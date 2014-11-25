package com.tgz.foosball.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public class GameInput implements KeyListener {

    public class Key {
        public int presses, absorbs;
        public boolean down, clicked;

        public Key() {
            keys.add(this);
        }

        public void toggle(boolean pressed) {
            if (pressed != down) {
                down = pressed;
            }
            if (pressed) {
                presses++;
            }
        }

        public void tick() {
            if (absorbs < presses) {
                absorbs++;
                clicked = true;
            } else {
                clicked = false;
            }
        }
    }

    public List<Key> keys = new ArrayList<Key>();

    public Key up = new Key();
    public Key down = new Key();
    public Key W = new Key();
    public Key S = new Key();
    public Key esc = new Key();


    public void tick() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).tick();
        }
    }

    public GameInput(Game game) {
        game.addKeyListener(this);
    }

    public void releaseAll() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).down = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }

    private void toggle(KeyEvent ke, boolean pressed) {
        if (ke.getKeyCode() == KeyEvent.VK_UP) up.toggle(pressed);
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) down.toggle(pressed);
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) esc.toggle(pressed);
        if (ke.getKeyCode() == KeyEvent.VK_W) W.toggle(pressed);
        if (ke.getKeyCode() == KeyEvent.VK_S) S.toggle(pressed);

    }

}
