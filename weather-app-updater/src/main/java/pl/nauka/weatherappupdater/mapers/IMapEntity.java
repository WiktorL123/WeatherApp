package pl.nauka.weatherappupdater.mapers;

public interface IMapEntity <TEntity, TDto>{
    TEntity map(TDto dto);
    TEntity map(TDto dto, TEntity entity);

}
