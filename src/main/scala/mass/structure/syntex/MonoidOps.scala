package mass.structure
package syntax

final class MonoidOps[F](val self: F)(implicit val F: Monoid[F]) {
}

trait ToMonoidOps extends ToSemigroupOps {
  implicit def ToMonoidOps[F](v: F)(implicit F0: Monoid[F]) =
    new MonoidOps[F](v)

  def mzero[F](implicit F: Monoid[F]): F = F.zero
}

trait MonoidSyntax[F] extends SemigroupSyntax[F] {
  implicit def ToMonoidOps(v: F): MonoidOps[F] = new MonoidOps[F](v)(MonoidSyntax.this.F)

  def F: Monoid[F]

  def mzero(implicit F: Monoid[F]): F = F.zero
}
