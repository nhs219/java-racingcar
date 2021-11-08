package edu.nextstep.camp;

import java.util.Random;

public class RandomMovePolicy implements MovePolicy {
    private static final int MAXIMUM = 10;
    private static final int MOVE_THRESHOLD = 4;

    private final Random random = new Random();

    @Override
    public boolean needToMove() {
        return random.nextInt(MAXIMUM) > MOVE_THRESHOLD;
    }
}