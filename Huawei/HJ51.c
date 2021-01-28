#include "stdlib.h"
#include "stdio.h"


typedef struct ListNode{

    int m_nKey;
    struct ListNode* m_pNext;
}ListNode;
int main(){

    int N =0 ;

    while(scanf("%d",&N) != EOF){


        ListNode *head = (ListNode *)malloc(sizeof(ListNode));
        scanf("%d",&head->m_nKey);

        ListNode *pre = head;
        ListNode *next = NULL;


        for (int i = 1; i < N; ++i) {

            next = (ListNode *)malloc(sizeof(ListNode));


            scanf("%d",&next->m_nKey);

            next->m_pNext = NULL;

            pre->m_pNext = next;
            pre = next;

        }

        int k = 0;

        scanf("%d",&k);

        if(k == 0){
            printf("0\r\n");
            continue;
        }

        pre = head;
        for (int j = 0; j < N-k; ++j) {
            pre = pre->m_pNext;
        }
        printf("%d\r\n",pre->m_nKey);

        pre = head;
        next = head->m_pNext;
        while(next != NULL){
            free(pre);
            pre = next;
            next = next->m_pNext;
        }




    }




    return 0;
}
