package mass.structure
package syntax

final class SemigroupOps[F](val self: F)(implicit val F: Semigroup[F]) {

  final def product(other: => F) = F.product(self, other)

  final def ⊙(other: => F) = F.product(self, other)
}

trait ToSemigroupOps  {
  implicit def ToSemigroupOps[F](v: F)(implicit F0: Semigroup[F]) =
    new SemigroupOps[F](v)
}

trait SemigroupSyntax[F]  {
  implicit def ToSemigroupOps(v: F): SemigroupOps[F] = new SemigroupOps[F](v)(SemigroupSyntax.this.F)

  def F: Semigroup[F]

  def product(f1: F, f2: => F)(implicit F: Semigroup[F]): F = F.product(f1, f2)

}
