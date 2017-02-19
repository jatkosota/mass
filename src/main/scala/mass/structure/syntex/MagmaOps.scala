package mass.structure
package syntax

final class MagmaOps[F](val self: F)(implicit val F: Magma[F]) {

  final def product(other: => F) = F.product(self, other)

  final def ⊙(other: => F) = F.product(self, other)
}

trait ToMagmaOps  {
  implicit def ToMagmaOps[F](v: F)(implicit F0: Magma[F]) =
    new MagmaOps[F](v)
}

trait MagmaSyntax[F]  {
  implicit def ToMagmaOps(v: F): MagmaOps[F] = new MagmaOps[F](v)(MagmaSyntax.this.F)

  def F: Magma[F]

  def product(f1: F, f2: => F)(implicit F: Magma[F]): F = F.product(f1, f2)
}
