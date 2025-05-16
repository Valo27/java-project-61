package hexlet.code;

/**
 * Класс конфигурации игры.
 * Содержит настройки для всех игровых модулей
 */
public class GameConfig {

    /**
     * Максимальное количество раундов в игре.
     * Константа определяет, сколько попыток дается игроку
     * в каждой игре
     */
    private static final int MAX_ROUNDS = 3;

    /**
     * Метод получения максимального количества раундов.
     * @return количество раундов для игры
     */
    public static int getMaxRounds() {
        return MAX_ROUNDS;
    }
}
