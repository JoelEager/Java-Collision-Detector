class Main {
    public static void main(String[] args) {
        String iterations = args[0];

        if (iterations == null) {
            System.out.println("Usage:\njava [java args] MainJava [iterations]");
            return;
        }

        System.out.println("Benchmarking sat.hasCollided() using a shell and tank...");
        System.out.println("Using $iterations iterations\n");

        System.out.println("Time with maxDist: ${runTest(iterations, 15.56)}");
        System.out.println("Time without:      ${runTest(iterations)}");
    }

    double runTest(int iterations, Double maxDist) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i <iterations; i++) {
            Vector[] tank = { new Vector(195.0, 95.0), new Vector(205.0, 95.0),
                    new Vector(205.0, 105.0), new Vector(195.0, 105.0) };
            Vector[] shell = { new Vector(99.5, 99.5), new Vector(100.5, 99.5),
                    new Vector(100.5, 100.5), new Vector(99.5, 100.5) };

            while (!hasCollided(tank, shell, maxDist)) {
                // Move the shell
                for (Vector vector : shell) {
                    vector.x += 1.0;
                }
            }
        }

        return (System.currentTimeMillis() - startTime) / 1000.0;
    }
}