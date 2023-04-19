package com.cristian.design.patterns;

import com.cristian.design.patterns.models.Fatigue;
import com.cristian.design.patterns.models.Health;
import com.cristian.design.patterns.models.Nourishment;

public record Command(Fatigue fatigue, Health health, Nourishment nourishment) {

}
