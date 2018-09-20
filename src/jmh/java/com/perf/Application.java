package com.perf;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javolution.util.FastMap;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;


// https://daniel.mitterdorfer.name/articles/2014/benchmarking-hello-jmh/
public class Application {

    @State(Scope.Benchmark)
    public static class Constants {
        int SIZE = 10000000;
        int MAX = Integer.MAX_VALUE; // max value
        int MIN = 0; // min value

        Map<String, Integer> connectionMap = new ConcurrentHashMap<>();
        FastMap<String, Integer> connectionFastMap = new FastMap<String, Integer>().shared();

        int[] randomArray = new int[SIZE];

        @Setup(Level.Trial)
        public void doSetup() {
            System.out.println("Do Setup");
            for(int idx = 0; idx < SIZE; idx++) {
                int n = new Random().nextInt(MAX) + MIN;
                connectionMap.put(String.valueOf(n), n );
                connectionFastMap.put(String.valueOf(n), n );

            }
        }
        @TearDown(Level.Trial)
        public void doTearDown() {
            System.out.println("Do TearDown");
        }
    }


    // test without parallel
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
  //  @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 3, warmups = 1)
    @Measurement(iterations = 3)
    public Map<String, Integer> map(Constants consts) {
        final Map<String, Integer> connectionMap = consts.connectionMap;
        AtomicLong evenCount = new AtomicLong(0L);
        connectionMap.forEach( (strVal, intVal) -> {
            if (intVal % 2 == 0) {
                evenCount.incrementAndGet();
            }
        });

        return connectionMap;
    }

    // test with parallel
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    //@OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 3, warmups = 1)
    @Measurement(iterations = 3)
    public FastMap<String, Integer> fastMap(Constants consts) {
        final FastMap<String, Integer> connectionMap = consts.connectionFastMap;
        AtomicLong evenCount = new AtomicLong(0L);
        connectionMap.forEach( (strVal, intVal) -> {
            //Integer intVal = entry.getValue();
            if (intVal % 2 == 0) {
                evenCount.incrementAndGet();
            }
        });

        return connectionMap;
    }


}
