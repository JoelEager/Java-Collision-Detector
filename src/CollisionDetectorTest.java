class CollisionDetectorTest {
    public static void main(String[] args) {
        int iterations;

        try {
            iterations = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Usage:\njava CollisionDetectorTest [iterations]");
            return;
        }

        System.out.println("Benchmarking sat.hasCollided() using a shell and tank...");
        System.out.println("Using " + iterations + " iterations\n");

        System.out.println("Time with maxDist: " + runTest(iterations, 15.56));
        System.out.println("Time without:      " + runTest(iterations, null));
    }

    private static double runTest(int iterations, Double maxDist) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i <iterations; i++) {
            Sat.Vector[] tank = { new Sat.Vector(195.0, 95.0), new Sat.Vector(205.0, 95.0),
                    new Sat.Vector(205.0, 105.0), new Sat.Vector(195.0, 105.0) };
            Sat.Vector[] shell = { new Sat.Vector(99.5, 99.5), new Sat.Vector(100.5, 99.5),
                    new Sat.Vector(100.5, 100.5), new Sat.Vector(99.5, 100.5) };

            while (Sat.hasCollided(tank, shell, maxDist)) {
                // Move the shell
                for (Sat.Vector vector : shell) {
                    vector.x += 1.0;
                }
            }
        }

        return (System.currentTimeMillis() - startTime) / 1000.0;
    }
}