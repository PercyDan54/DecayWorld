# DecayWorld
Spigot plugin to implement 20w14infinite decay dimension effect

## Usage
Specify this plugin as the world generator in your `bukkit.yml`
``` YAML
worlds:
  world:
    generator: DecayWorld
```

### Configuration
You can set an offset to reach high decay strength at near world center:

`generator: DecayWorld`: No offset

`generator: DecayWorld:40`: Offset both `x` and `z` by 40 chunks

`generator: DecayWorld:40,30`: Offset `x` by 40 chunks and `z` by 30 chunks
