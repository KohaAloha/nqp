package org.perl6.nqp.truffle.nodes.expression;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import org.perl6.nqp.truffle.nodes.NQPNode;
import org.perl6.nqp.truffle.nodes.NQPStrNode;
import org.perl6.nqp.truffle.runtime.NQPListStr;
import org.perl6.nqp.dsl.Deserializer;

@NodeInfo(shortName = "bindpos_s")
public final class NQPBindposStrNode extends NQPStrNode {
    @Child private NQPNode listNode;
    @Child private NQPNode indexNode;
    @Child private NQPNode valueNode;

    @Deserializer
    public NQPBindposStrNode(NQPNode listNode, NQPNode indexNode, NQPNode valueNode) {
        this.listNode = listNode;
        this.indexNode = indexNode;
        this.valueNode = valueNode;
    }

    @Override
    public String executeStr(VirtualFrame frame) {
        return ((NQPListStr)listNode.execute(frame)).bindposStr(indexNode.executeInt(frame), valueNode.executeStr(frame));
    }
}
