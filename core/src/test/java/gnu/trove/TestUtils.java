package gnu.trove;

import gnu.trove.list.array.TIntArrayList;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class TestUtils {
    public static void testDeserialization(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream( bytesOut );
        objOut.writeObject( object );
        objOut.close();

        ObjectInputStream objIn = new ObjectInputStream(
                new ByteArrayInputStream( bytesOut.toByteArray() ) );

        TIntArrayList deserializedObject = (TIntArrayList) objIn.readObject();

        assertEquals( object, deserializedObject );
    }
}
