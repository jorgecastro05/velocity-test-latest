package org.acme;

import io.quarkus.runtime.annotations.RegisterForReflection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RegisterForReflection(targets = {
        List.class,
        Map.class,
        ArrayList.class,
        HashMap.class,
        Iterable.class,
        Iterator.class
})
public class ReflectionConfiguration {
}
