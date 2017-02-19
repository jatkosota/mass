package mass.structure

trait Magma[F] {

  def product(f1: F, f2: => F): F
}
