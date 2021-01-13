#include <stdio.h>
#include <string.h>



// 时间超时
void solution01(){

    char buf[1024];
    while(gets(buf) != 0){


        char *iP ;
        char *jP ;
        for ( iP = buf; *iP != '\0'; iP++) {
            printf("iP:%c \r\n",*iP);

            for ( jP = buf; jP != iP ; jP++) {
                if(*iP < *jP){

                    char tmp = *iP;
                    *iP = *jP;
                    *jP = tmp;

                }
            }

        }

        printf("%s",buf);


    }
}
void swap(char buf[] ,int x,int y){
    char tmp = buf[x];
    buf[x] = buf[y];
    buf[y] = tmp;

}

int partition(char* buf ,int left ,int right){

    int pivot = left;
    int index = pivot+1;
    for (int i = index; i <= right; i++) {
        if (buf[i] < buf[pivot]) {
            // 将比索引值小的元素放到较前面的位置上
            swap(buf, i, index);
            index++;
        }
    }
    // 基准值放到分割点上
    swap(buf, pivot, index - 1);
    // 最后作为大小两部分的分割点的索引
    return index - 1;

}

char* quickSort(char* buf,int left,int right){

//    printf("%s\r\n",buf);
    if(left < right){
        int partitionIndex = partition(buf,left,right);
        quickSort(buf,left,partitionIndex-1);
        quickSort(buf,partitionIndex+1,right);
    }

    return buf;


}

int main(){

    char buf[1025];
    char *p = NULL;
    while (gets(buf) != 0){

        int len = strlen(buf);
        p = NULL;
        p = quickSort(buf,0,len-1);
        printf("%s\r\n",p);


    }

    return 0;
}
