package mass.structure

trait Semigroup[F] extends Magma[F] {

  def product(f1: F, f2: => F): F
}
