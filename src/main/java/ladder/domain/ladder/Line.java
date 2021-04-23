package ladder.domain.ladder;

import ladder.domain.strategy.LineGenerateStrategy;
import ladder.exception.PointListNullPointerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public final class Line {

    private static final int START_INCLUSIVE = 0;
    private static final int TWO = 2;

    private final List<Point> line;

    public static final Line of(final int countOfPerson, final LineGenerateStrategy strategy) {
        return of(init(countOfPerson, strategy));
    }

    public static final Line of(final List<Point> line) {
        return new Line(line);
    }

    public Line(final List<Point> line) {
        validateNull(line);
        this.line = line;
    }

    private final void validateNull(final List<Point> line) {
        if (Objects.isNull(line)) {
            throw new PointListNullPointerException();
        }
    }

    private static final List<Point> init(final int countOfPerson, final LineGenerateStrategy strategy) {
        List<Point> points = new ArrayList<>();
        points.add(getFirst(strategy));
        IntStream.range(START_INCLUSIVE, countOfPerson - TWO)
                .forEach(before -> points.add(getNext(strategy, points, before)));
        points.add(getLast(countOfPerson, points));
        return points;
    }

    private static final Point getFirst(final LineGenerateStrategy strategy) {
        return Point.first(strategy.generate());
    }

    private static final Point getNext(final LineGenerateStrategy strategy, final List<Point> points, final int before) {
        return points.get(before).next(strategy);
    }

    private static final Point getLast(final int countOfPerson, final List<Point> points) {
        return points.get(countOfPerson - TWO).last();
    }

}
