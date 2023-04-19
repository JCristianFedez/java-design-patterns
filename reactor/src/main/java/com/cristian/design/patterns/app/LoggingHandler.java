package com.cristian.design.patterns.app;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

import com.cristian.design.patterns.framework.AbstractNioChannel;
import com.cristian.design.patterns.framework.ChannelHandler;
import com.cristian.design.patterns.framework.NioDatagramChannel.DatagramPacket;

import lombok.extern.slf4j.Slf4j;

/**
 * Logging server application logic. It logs the incoming requests on standard console and returns a canned acknowledgement back to the
 * remote peer.
 */
@Slf4j
public class LoggingHandler implements ChannelHandler {

  private static final byte[] ACK = "Data logged successfully".getBytes();

  private static void sendReply(AbstractNioChannel channel, DatagramPacket incomingPacket, SelectionKey key) {
    /*
     * Create a reply acknowledgement datagram packet setting the receiver to the sender of incoming
     * message.
     */
    var replyPacket = new DatagramPacket(ByteBuffer.wrap(ACK));
    replyPacket.setReceiver(incomingPacket.getSender());

    channel.write(replyPacket, key);
  }

  private static void sendReply(AbstractNioChannel channel, SelectionKey key) {
    var buffer = ByteBuffer.wrap(ACK);
    channel.write(buffer, key);
  }

  private static void doLogging(ByteBuffer data) {
    // assuming UTF-8 :(
    LOGGER.info(new String(data.array(), 0, data.limit()));
  }

  /**
   * Decodes the received data and logs it on standard console.
   */
  @Override
  public void handleChannelRead(AbstractNioChannel channel, Object readObject, SelectionKey key) {
    /*
     * As this handler is attached with both TCP and UDP channels we need to check whether the data
     * received is a ByteBuffer (from TCP channel) or a DatagramPacket (from UDP channel).
     */
    if (readObject instanceof ByteBuffer) {
      doLogging((ByteBuffer) readObject);
      sendReply(channel, key);
    } else if (readObject instanceof DatagramPacket datagram) {
      doLogging(datagram.getData());
      sendReply(channel, datagram, key);
    } else {
      throw new IllegalStateException("Unknown data received");
    }
  }
}
