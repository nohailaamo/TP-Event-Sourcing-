package amouhal.nouhayla.accountservice.commenApi.events;

import lombok.Getter;

public class BaseEvent <T> {

    private T id;

    public T getId() {
        return id;
    }

    public BaseEvent(T id) {
        this.id = id;
    }

}
