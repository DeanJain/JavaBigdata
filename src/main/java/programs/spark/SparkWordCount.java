/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.spark;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.util.LongAccumulator;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SparkWordCount {

    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) {

        SparkSession spark = SparkSession
                .builder()
                .appName("SparkWordCount")
                .config("spark.master", "local")
                .getOrCreate();

        Scanner input = new Scanner(System.in);
        String FilePath = input.nextLine();

        LongAccumulator la = spark.sparkContext().longAccumulator();

        JavaRDD<String> lines = spark.read().textFile(FilePath).javaRDD().cache();

        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)).iterator());

        JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));

        JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1 + i2);

        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<?, ?> tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
            la.add(Long.parseLong((String) tuple._2()));
        }
        System.out.println(la.count());
        spark.stop();
    }

}