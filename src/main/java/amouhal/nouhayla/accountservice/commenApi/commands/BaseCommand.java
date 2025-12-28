package amouhal.nouhayla. accountservice.commenApi.commands;

public abstract class BaseCommand<T> {
    private T id;

    public BaseCommand(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}