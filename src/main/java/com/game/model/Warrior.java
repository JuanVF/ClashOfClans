package com.game.model;

import com.game.model.Handles.HandlerGameObjects;
import com.game.model.Interfaces.IMoveable;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>Todos los personajes que van a estar en un bando</h1>
 * */
public abstract class Warrior extends Fighter implements IMoveable {

    private int health;
    private int maxHealth;
    protected int troops;
    protected Point nextMove;
    protected int growthRate;

    /**
     * <h1>Constructor para que el usuario cree sus personajes</h1>
     * @param images debe haber al menos 1 imagen, la primera imagen es por defecto
     * */
    public Warrior(ID id, String name, int maxHealth, int troops, int appearanceLevel, int range, int strokePerTime, int speed, ImageIcon[] images) {
        super(id, Team.FRIEND, name, range, strokePerTime, 1, appearanceLevel, speed, images);
        setHealth(maxHealth);
        this.troops = troops;
    }

    /**
     * <h1>para clonar</h1>
     * */
    public Warrior(Warrior warrior, GameBoard gameBoard, HandlerGameObjects handlerGameObjects) {
        super(warrior, gameBoard, handlerGameObjects);
        setHealth(warrior.maxHealth);
        this.troops = warrior.troops;
    }

   protected void displayHealthBar(Graphics g){
        double x = hitBox.getX(), y = hitBox.getY();

        g.setColor(getTeam() == Team.FRIEND ? Color.cyan: Color.RED);
        // maximo de la barrra es 35
        int width = health*35/maxHealth;
        g.fillRoundRect((int)(x+2), (int)y, width, 5, 1,1);
        g.setColor(Color.BLACK);
        g.drawString(""+health, (int)(x+2+4), (int)y+5);
   }

   public final void reduceHealth(int damage){
        health -= damage;
        if(health <= 0){
            die();
            health = 0;
        }
   }

   public boolean isDead(){
        return health <=0;
   }

    public void hit(int damage) {
        reduceHealth(damage);
    }

    public void die() {
        setImage(images[2].getImage());
        gameBoard.removeCharacter(this);
        handlerGameObjects.removeObject(this);
    }

    public abstract Point heuristic();

    // retorna random -1,0,1
    public int getMovement(){
        double a = random.nextInt(100);
        if(a < 100/3) return -1;
        if(a >= 100/3 && a < (200/3)) return 1;
        return 0;
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        displayHealthBar(g);
    }

    @Override
    public void tick() {
        if(framesTimer == frames){
            if(isSomeoneInRange())attack();
            else move();

            framesTimer = 0;
        }else{
            framesTimer++;
        }
    }

    @Override
    public void attack() {
        super.attack();
        setImage(images[1].getImage());
    }

    @Override
    public void move() {
        setImage(images[0].getImage());
        int tries = 8;

        while (tries-- >0) {
            int x = getMovement();
            int y = getMovement();
            nextMove = new Point(x + location.x, y + location.y);

            if (!gameBoard.isPositionOccupied(nextMove)) {
                gameBoard.moveCharacter(getLocation(), nextMove);
                setLocation(nextMove);
                return;
            }
        }
    }
    // cuando vamos a jugar un nivel los personajes tienen stacks predeterminados
    @Override
    public void upgrade(int level){
        System.out.println("Level adfasdfasdf: " + level);
        System.out.println(getLevel());

        if(level > 5) level = 5;

        if(level > 1){
            for (int i = 1; i < level; i++) levelUp();
        }

        /*
        //System.out.println("\n-------");
        //System.out.println("Se va a aumentar: " + getName() + "Stacks actuales: Health" + getHealth() + " range: " + range + " stroke" + strokePerTime+ " speed: " + getSeep());

        double percentage = growth(level);

        setHealth((int) (getHealth() + getHealth() * percentage));
        strokePerTime = (int) (strokePerTime + strokePerTime * percentage);

        // Aumenta el rango si el nivel es 3 o 5
        // Luego quedan muy rotos xD
        if (level % 2 != 0) range++;

        //System.out.println("resultado: " + getName() + "Stacks actuales: Health" + getHealth() + " range: " + range + " stroke" + strokePerTime+ " speed: " + getSeep());
        //System.out.println("-------\n");*/
    }

    // Sube de nivel en base al nivel actual
    @Override
    public void levelUp(){
        //System.out.println("Level: " + getLevel());
        if (getLevel() > 5) return;

       /* System.out.println("\n-------");
        System.out.println("Level: " + getLevel());
        System.out.println("Se va a aumentar: " + getName() + "Stacks actuales: Health" + getHealth() + " range: " + range + " stroke" + strokePerTime+ " speed: " + getSeep());
*/
        double percentage = growth(getLevel()) + growthRate;

        setHealth((int) (getHealth() + getHealth() * percentage));
        strokePerTime = (int) (strokePerTime + strokePerTime * percentage);

        // Aumenta el rango si el nivel es 3 o 5
        // Luego quedan muy rotos xD
        if (getLevel() % 2 != 0) range++;
        setLevel(getLevel() + 1);

      /*  System.out.println("resultado: " + getName() + "Stacks actuales: Health" + getHealth() + " range: " + range + " stroke" + strokePerTime+ " speed: " + getSeep());
        System.out.println("-------\n");*/
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
        maxHealth = health;
    }

    public int getTroops() {
        return troops;
    }

    public void setTroops(int troops) {
        this.troops = troops;
    }

    public abstract Warrior clone(Warrior w);

    @Override
    public String toString() {
        return "Warrior{" +
                "health=" + health +
                ", maxHealth=" + maxHealth +
                ", troops=" + troops +
                ", nextMove=" + nextMove +
                ", range=" + range +
                ", strokePerTime=" + strokePerTime +
                ", cooldown=" + cooldown +
                ", timer=" + timer +
                ", appearanceLevel=" + appearanceLevel +
                ", frames=" + frames +
                ", framesTimer=" + framesTimer +
                ", target=" + target +
                ", gameBoard=" + gameBoard +
                ", handlerGameObjects=" + handlerGameObjects +
                ", location=" + location +
                ", id=" + id +
                ", velX=" + velX +
                ", velY=" + velY +
                ", img=" + img +
                ", hitBox=" + hitBox +
                '}';
    }

    // Lo que quiero con esto es que crezca un X% mas rapido o mas lento si es negativo
    // Asuma que se lo pasamos en porcentajes (0% - 100%)
    public void setGrowthRate(int growthRate) {
        growthRate /= 100;
        this.growthRate = growthRate;
    }
}