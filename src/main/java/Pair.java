import java.util.Objects;

public class Pair<L, R> {

    private L left;
    private R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> that = (Pair<?, ?>) o;
        return  (Objects.equals(this.left, that.left) && Objects.equals(this.right, that.right)) ||
                (Objects.equals(this.left, that.right) && Objects.equals(this.right, that.left));
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }


}
