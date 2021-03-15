package me.linxiaowei.flink;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * WordCount
 *
 * @author <a href="mailto://linxiaowei.me@gmail.com">LinXiaoWei</a>
 * @date 2021/1/26 16:27
 */
public class WordCount {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> in = env.fromElements("123", "234", "567");

        in.map((MapFunction<String, Integer>) value -> Integer.valueOf(value))
                .filter((FilterFunction<Integer>) value -> value > 200)
                .print();

        env.execute("test");
    }

}
