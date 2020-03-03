package implementations;

import interfaces.Parser;
import interfaces.Particle;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private List<Particle> particles;
    private double L;
    private double M;
    private int N;

    public ParserImpl(){
        this.particles = new ArrayList<Particle>();
    }

    public void parse() {



        try {
            File staticFile = new File(getClass().getClassLoader().getResource("static.txt").getFile());
            Scanner staticReader = new Scanner(staticFile);

            File dynamicFile = new File(getClass().getClassLoader().getResource("dynamic.txt").getFile());
            Scanner dynamicReader = new Scanner(dynamicFile);

            N = staticReader.nextInt();
            L = staticReader.nextFloat();

            dynamicReader.nextDouble(); //Skip time

            int i = 0;

            while(staticReader.hasNext() && dynamicReader.hasNext()){
                Particle p = new ParticleImpl(dynamicReader.nextDouble(),dynamicReader.nextDouble(),staticReader.nextDouble(),i);
                particles.add(p);
                i++;
            }

            for (Particle p : particles) {
                System.out.println(p.getId());
            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


}
