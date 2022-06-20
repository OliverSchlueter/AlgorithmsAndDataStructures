package algorithms;

/**
 * @param <I> input type (array, list, map ...)
 * @param <S> searched type (String, Integer, Float ...)
 * @param <R> return type (found: yes/no, item itself, index of item in list ...)
 */
public interface SearchAlgorithm<I, S, R> {
    R search(S searched, I input);
}
