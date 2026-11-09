package entrenamiento;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;



// Solución Claude
public class WheelerZumoLimon2 {
    static DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
    static byte[] buf = new byte[1 << 16];
    static int len = 0, ptr = 0;

    static int readByte() throws IOException {
        if (ptr == len) {
            len = in.read(buf, 0, buf.length);
            ptr = 0;
            if (len <= 0) return -1;
        }
        return buf[ptr++];
    }

    static int nextInt() throws IOException {
        int c = readByte();
        while (c != -1 && (c < '0' || c > '9')) c = readByte();
        if (c == -1) return -1;
        int r = 0;
        while (c >= '0' && c <= '9') {
            r = r * 10 + (c - '0');
            c = readByte();
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = nextInt()) > 0) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            long[] k = new long[n];
            for (int i = 0; i < n; i++) {
                int b = nextInt();
                long d = (long) b - a[i];          // sobreestimación (> 0)
                k[i] = ((long) a[i] << 32) | d;    // a en los bits altos, d en los bajos
            }
            Arrays.sort(k);                        // orden por evaluación ascendente

            boolean ok = true;
            long prev = k[0] & 0xFFFFFFFFL;
            for (int i = 1; i < n; i++) {
                long d = k[i] & 0xFFFFFFFFL;
                if (d >= prev) { ok = false; break; }  // debe decrecer estrictamente
                prev = d;
            }
            sb.append(ok ? "SI" : "NO").append('\n');
        }
        System.out.print(sb);
    }
}