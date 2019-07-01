import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class SpliteratorWrapper<T> implements Spliterator<T> {

    public static void main(String[] args) {
        final boolean parallel = true;
        Map<String, Spliterator<Integer>> input = new LinkedHashMap<>();
        input.put("List",
                Arrays.asList(0, 1, 2, 3).spliterator());
        input.put("Set",
                IntStream.range(0, 4)
                        .boxed()
                        .collect(Collectors.toSet())
                        .spliterator());
        input.put("Arrays.spliterator",
                Arrays.spliterator(new int[] {0, 1, 2, 3}));
        input.put("Stream.of",
                Stream.of(0, 1, 2, 3).spliterator());
        input.put("Stream.of + distinct",
                Stream.of(0, 1, 2, 3).distinct().spliterator());
        input.put("Stream.of + distinct + map",
                Stream.of(0, 1, 2, 3).distinct().map(x -> x + 1).spliterator());

        input.forEach((name, s) -> {
            counter = 1;
            System.out.println(name);
            final List<Row> rows = new CopyOnWriteArrayList<>();
            Spliterator<Integer> spliterator = new SpliteratorWrapper<>(s, rows);
            long count = StreamSupport.stream(spliterator, parallel)
                    .count();
            rows.stream()
                    .sorted(Comparator.comparing(Row::time))
                    .forEach(System.out::println);
            System.out.print("count: ");
            System.out.println(count);
            System.out.println();
        });
    }

    private static final Map<Integer, String> NAMES;
    static {
        NAMES = new HashMap<>();
        NAMES.put(Spliterator.ORDERED, "ORDERED");
        NAMES.put(Spliterator.SORTED, "SORTED");
        NAMES.put(Spliterator.DISTINCT, "DISTINCT");
        NAMES.put(Spliterator.SIZED, "SIZED");
        NAMES.put(Spliterator.SUBSIZED, "SUBSIZED");
        NAMES.put(Spliterator.NONNULL, "NONNULL");
        NAMES.put(Spliterator.IMMUTABLE, "IMMUTABLE");
        NAMES.put(Spliterator.CONCURRENT, "CONCURRENT");
    }

    private static int counter;

    public static class Row {
        String tag;
        String threadName;
        String methodName;
        String info;
        long time;

        public long time() {
            return time;
        }

        @Override
        public String toString() {
            return String.format("[%s][%s] %s%s", threadName, tag, methodName, info);
        }
    }

    private final String tag;
    private final Spliterator<T> spliterator;
    private final List<Row> rows;

    public SpliteratorWrapper(Spliterator<T> spliterator, List<Row> rows) {
        this(spliterator, rows, "main");
    }

    public SpliteratorWrapper(Spliterator<T> spliterator, List<Row> rows, String tag) {
        this.tag = tag;
        this.spliterator = spliterator;
        this.rows = rows;
    }

    private Row createRow(String methodName) {
        final Row row = new Row();
        row.threadName = Thread.currentThread().getName();
        row.methodName = methodName;
        row.tag = this.tag;
        return row;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        final Row row = createRow("tryAdvance");
        boolean result = spliterator.tryAdvance(action);
        row.info = ": " + result;
        rows.add(row);
        return result;
    }

    @Override
    public Spliterator<T> trySplit() {
        final Row row = createRow("trySplit");
        Spliterator<T> result = spliterator.trySplit();
        if (result == null) {
            row.info = ": null";
        } else {
            row.info = String.format("%n  %s%n", result.toString());
            row.info += String.format("  size: %d%n", result.estimateSize());
            row.info += String.format("  characteristics: %s", getCharacteristics(result.characteristics()));
            result = new SpliteratorWrapper<>(result, rows, "split-" + (counter++));
        }
        rows.add(row);
        return result;
    }

    @Override
    public long estimateSize() {
        final Row row = createRow("estimateSize");
        long result = spliterator.estimateSize();
        row.info = ": " + result;
        rows.add(row);
        return result;
    }

    @Override
    public int characteristics() {
        final Row row = createRow("characteristics");
        final int result = spliterator.characteristics();
        row.info = ": " + getCharacteristics(result);
        rows.add(row);
        return result;
    }

    private static String getCharacteristics(final int result) {
        return NAMES.entrySet().stream()
                .filter(e -> (result & ((int)e.getKey())) != 0)
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(" | "));
    }
}