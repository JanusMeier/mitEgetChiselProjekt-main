import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec


class RiscVtester extends AnyFlatSpec with ChiselScalatestTester {
  "RiscV test" should "pass" in {
    test(new main(50)).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
      println("We are generting a VCD file with the test of the Risc-V simulator")
      dut.io.Instin.poke("b01000000000100010000000110110011".U)
      dut.clock.step(2)
      for (i <- 0 until 4)
        println("reg"+i+ " is  " + dut.io.Regso(i).peekInt())
    }
  }
}