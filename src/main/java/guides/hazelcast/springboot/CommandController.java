package guides.hazelcast.springboot;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/hazelcast")
public class CommandController {
    @Autowired
    private HazelcastInstance hazelcastInstance;

    private ConcurrentMap<String,String> retrieveMap() {
        return hazelcastInstance.getMap("map");
    }

    @PostMapping
    public CommandResponse put(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        retrieveMap().put(key, value);
        return new CommandResponse(value);
    }

    @GetMapping
    public CommandResponse get(@RequestParam(value = "key") String key) {
        String value = retrieveMap().get(key);
        return new CommandResponse(value);
    }
}
