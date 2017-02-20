package mass.structure

trait Monoid[F] extends Semigroup[F] {

  def identity: F

  def e: F
}
