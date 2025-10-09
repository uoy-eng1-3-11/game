package io.github.mazegame;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public final class Extenstions {
    
    public static Vector2 vectorLerp(Vector2 startVector, Vector2 endVector, float progress){
        return new Vector2(
            MathUtils.lerp(startVector.x, endVector.x, progress),
            MathUtils.lerp(startVector.y, endVector.y, progress));
    }

    public static float distanceSquared(Vector2 vectorA, Vector2 vectorB){
        return ((vectorA.x - vectorB.x) * (vectorA.x - vectorB.x) + (vectorA.y - vectorB.y) * (vectorA.y - vectorB.y));
    }

    public static float distance(Vector2 vectorA, Vector2 vectorB){
        return (float)Math.sqrt(distanceSquared(vectorA, vectorB));
    }
}
