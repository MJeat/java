public class Link<T> {
    T data;
    Link<T> next;

    public Link(T data) {
        this.data = data;
        this.next = null;
    }
}
